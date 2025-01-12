package com.github.wilwe21.gsad.block.custom.random.negative;

import com.github.wilwe21.gsad.Gsad;
import com.github.wilwe21.gsad.render.CustomRenderLayers;
import net.minecraft.block.AirBlock;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import org.joml.Matrix4f;

public class NegativeBlockEntityRenderer<T extends NegativeBlockEntity> implements BlockEntityRenderer<T> {
    public NegativeBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    public void render(T entity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        try {
            BlockState state = entity.getWorld().getBlockState(entity.getPos());
            if (!(state.getBlock() instanceof AirBlock)) {
                Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
                this.renderSides(state, matrix4f, vertexConsumerProvider.getBuffer(this.getLayer()));
            }
        } catch (Exception e) {
            Gsad.LOGGER.error(e.toString());
        }
    }

    private void renderSides(BlockState state, Matrix4f matrix, VertexConsumer vertexConsumer) {
        this.renderSide(state, matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, Direction.SOUTH);
        this.renderSide(state, matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, Direction.NORTH);
        this.renderSide(state, matrix, vertexConsumer, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.EAST);
        this.renderSide(state, matrix, vertexConsumer, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, Direction.WEST);
        this.renderSide(state, matrix, vertexConsumer, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, Direction.DOWN);
        this.renderSide(state, matrix, vertexConsumer, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, Direction.UP);
    }

    private void renderSide(
            BlockState state, Matrix4f pose, VertexConsumer consumer, float x0, float x1, float y0, float y1, float z0, float z1, float z2, float z3, Direction side
    ) {
        consumer.vertex(pose, x0, y0, z0);
        consumer.vertex(pose, x1, y0, z1);
        consumer.vertex(pose, x1, y1, z2);
        consumer.vertex(pose, x0, y1, z3);
    }

    protected RenderLayer getLayer() {
        return CustomRenderLayers.NEGATIVE;
    }
}
