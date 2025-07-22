package com.github.wilwe21.stargazer.screens.recipe.serializer;

import com.github.wilwe21.stargazer.Stargazer;
import com.github.wilwe21.stargazer.screens.recipe.StarforgeRecipe;
import com.github.wilwe21.stargazer.screens.recipe.StarforgeRecipeInput;
import com.google.common.annotations.VisibleForTesting;
import com.mojang.datafixers.kinds.Applicative;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.chars.CharArraySet;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Util;
import net.minecraft.util.dynamic.Codecs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class RawStarforgeShapedRecipe {
    private static final int MAX_WIDTH_AND_HEIGHT = 5;
    public static final char SPACE = ' ';
    public static final MapCodec<RawStarforgeShapedRecipe> CODEC = RawStarforgeShapedRecipe.Data.CODEC.flatXmap(
            RawStarforgeShapedRecipe::fromData,
            recipe -> recipe.data.map(DataResult::success).orElseGet(() -> DataResult.error(() -> "Cannot encode unpacked recipe")));
    public static final PacketCodec<RegistryByteBuf, RawStarforgeShapedRecipe> PACKET_CODEC = PacketCodec.tuple(PacketCodecs.VAR_INT,
            recipe -> recipe.width, PacketCodecs.VAR_INT,
            recipe -> recipe.height, Ingredient.OPTIONAL_PACKET_CODEC.collect(PacketCodecs.toList()),
            recipe -> recipe.ingredients, RawStarforgeShapedRecipe::create);
    private static final Logger log = LoggerFactory.getLogger(RawStarforgeShapedRecipe.class);
    private final int width;
    private final int height;
    private final List<Optional<Ingredient>> ingredients;
    private final Optional<RawStarforgeShapedRecipe.Data> data;
    private final int ingredientCount;
    private final boolean symmetrical;

    public RawStarforgeShapedRecipe(int width, int height, List<Optional<Ingredient>> ingredients, Optional<RawStarforgeShapedRecipe.Data> data) {
        this.width = width;
        this.height = height;
        this.ingredients = ingredients;
        this.data = data;
        this.ingredientCount = (int)ingredients.stream().flatMap(Optional::stream).count();
        this.symmetrical = Util.isSymmetrical(width, height, ingredients);
    }

    private static RawStarforgeShapedRecipe create(Integer width, Integer height, List<Optional<Ingredient>> ingredients) {
        return new RawStarforgeShapedRecipe(width, height, ingredients, Optional.empty());
    }

    public static RawStarforgeShapedRecipe create(Map<Character, Ingredient> key, String ... pattern) {
        return RawStarforgeShapedRecipe.create(key, List.of(pattern));
    }

    public static RawStarforgeShapedRecipe create(Map<Character, Ingredient> key, List<String> pattern) {
        RawStarforgeShapedRecipe.Data data = new RawStarforgeShapedRecipe.Data(key, pattern);
        return RawStarforgeShapedRecipe.fromData(data).getOrThrow();
    }

    private static DataResult<RawStarforgeShapedRecipe> fromData(RawStarforgeShapedRecipe.Data data) {
        String[] strings = RawStarforgeShapedRecipe.removePadding(data.pattern);
        int i = strings[0].length();
        int j = strings.length;
        ArrayList<Optional<Ingredient>> list = new ArrayList<Optional<Ingredient>>(i * j);
        CharArraySet charSet = new CharArraySet(data.key.keySet());
        for (String string : strings) {
            for (int k = 0; k < string.length(); ++k) {
                Optional<Ingredient> optional;
                char c = string.charAt(k);
                if (c == ' ') {
                    optional = Optional.empty();
                } else {
                    Ingredient ingredient = data.key.get(Character.valueOf(c));
                    if (ingredient == null) {
                        return DataResult.error(() -> "Pattern references symbol '" + c + "' but it's not defined in the key");
                    }
                    optional = Optional.of(ingredient);
                }
                charSet.remove(c);
                list.add(optional);
            }
        }
        if (!charSet.isEmpty()) {
            return DataResult.error(() -> "Key defines symbols that aren't used in pattern: " + String.valueOf(charSet));
        }
        return DataResult.success(new RawStarforgeShapedRecipe(i, j, list, Optional.of(data)));
    }

    /**
     * Removes empty space from around the recipe pattern.
     *
     * <p>Turns patterns such as:
     * <pre>
     * {@code
     * "   o"
     * "   a"
     * "    "
     * }
     * </pre>
     * Into:
     * <pre>
     * {@code
     * "o"
     * "a"
     * }
     * </pre>
     *
     * @return a new recipe pattern with all leading and trailing empty rows/columns removed
     */
    @VisibleForTesting
    static String[] removePadding(List<String> pattern) {
        int i = Integer.MAX_VALUE;
        int j = 0;
        int k = 0;
        int l = 0;
        for (int m = 0; m < pattern.size(); ++m) {
            String string = pattern.get(m);
            i = Math.min(i, RawStarforgeShapedRecipe.findFirstSymbol(string));
            int n = RawStarforgeShapedRecipe.findLastSymbol(string);
            j = Math.max(j, n);
            if (n < 0) {
                if (k == m) {
                    ++k;
                }
                ++l;
                continue;
            }
            l = 0;
        }
        if (pattern.size() == l) {
            return new String[0];
        }
        String[] strings = new String[pattern.size() - l - k];
        for (int o = 0; o < strings.length; ++o) {
            strings[o] = pattern.get(o + k).substring(i, j + 1);
        }
        return strings;
    }

    private static int findFirstSymbol(String line) {
        int i;
        for (i = 0; i < line.length() && line.charAt(i) == ' '; ++i) {
        }
        return i;
    }

    private static int findLastSymbol(String line) {
        int i;
        for (i = line.length() - 1; i >= 0 && line.charAt(i) == ' '; --i) {
        }
        return i;
    }

    public boolean matches(StarforgeRecipeInput input) {
        Stargazer.LOGGER.error("matching");
        for (int i = 0; i < 14; i++) {
            Optional<Ingredient> optional;
            if (i <= 2) {
                optional = this.ingredients.get(5+i);
            } else if (i <= 5) {
                optional = this.ingredients.get(5+1+i);
            } else if (i <= 8) {
                optional = this.ingredients.get(5+2+i);
            } else if (i == 9) {
                optional = this.ingredients.get(10);
            } else if (i == 10) {
                optional = this.ingredients.get(15);
            } else if (i == 11) {
                optional = this.ingredients.get(2);
            } else if (i == 12) {
                optional = this.ingredients.get(24);
            } else {
                optional = this.ingredients.get(20);
            }
            if (Ingredient.matches(optional, input.getStackInSlot(i))) continue;
            return false;
        }
        return true;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public List<Optional<Ingredient>> getIngredients() {
        return this.ingredients;
    }

    public record Data(Map<Character, Ingredient> key, List<String> pattern) {
        private static final Codec<List<String>> PATTERN_CODEC = Codec.STRING.listOf().comapFlatMap(pattern -> {
            if (pattern.size() > 5) {
                return DataResult.error(() -> "Invalid pattern: too many rows, 5 is maximum");
            }
            if (pattern.isEmpty()) {
                return DataResult.error(() -> "Invalid pattern: empty pattern not allowed");
            }
            int i = ((String)pattern.getFirst()).length();
            for (String string : pattern) {
                if (string.length() > 5) {
                    return DataResult.error(() -> "Invalid pattern: too many columns, 5 is maximum");
                }
                if (i == string.length()) continue;
                return DataResult.error(() -> "Invalid pattern: each row must be the same width");
            }
            return DataResult.success(pattern);
        }, Function.identity());
        private static final Codec<Character> KEY_ENTRY_CODEC = Codec.STRING.comapFlatMap(keyEntry -> {
            if (keyEntry.length() != 1) {
                return DataResult.error(() -> "Invalid key entry: '" + keyEntry + "' is an invalid symbol (must be 1 character only).");
            }
            if (" ".equals(keyEntry)) {
                return DataResult.error(() -> "Invalid key entry: ' ' is a reserved symbol.");
            }
            return DataResult.success(Character.valueOf(keyEntry.charAt(0)));
        }, String::valueOf);
        public static final MapCodec<RawStarforgeShapedRecipe.Data> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codecs.strictUnboundedMap(KEY_ENTRY_CODEC, Ingredient.CODEC).fieldOf("key").forGetter(Data::key),
                PATTERN_CODEC.fieldOf("pattern").forGetter(Data::pattern)
        ).apply(instance, RawStarforgeShapedRecipe.Data::new));
    }
}
