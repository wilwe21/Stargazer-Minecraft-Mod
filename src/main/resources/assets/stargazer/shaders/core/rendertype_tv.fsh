#version 150

#moj_import <minecraft:matrix.glsl>

uniform sampler2D Sampler0;

uniform float GameTime;

in vec4 texProj0;

const vec3 COLORS = vec3(0.2, 0.2, 0.2);

const mat4 SCALE_TRANSLATE = mat4(
    1.0, 0.0, 0.0, 0.25,
    0.0, 1.0, 0.0, 0.25,
    0.0, 0.0, 8.0, 0.0,
    0.0, 0.0, 0.0, 8.0
);

mat4 tv_layer(float layer) {
    mat4 translate = mat4(
        1.0, 0.0, 0.0, (17.0 / layer) * (GameTime * 16),
        0.0, 1.0, 0.0, (2.0 + layer),
        0.0, 0.0, 1.0, 0.0,
        0.0, 0.0, 0.0, 1.0
    );
    mat2 rotate = mat2_rotate_z(radians(0.0));
    mat2 scale = mat2((4.5 - layer / 4.0) * 2.0);

    return mat4(scale * rotate) * translate * SCALE_TRANSLATE;
}

out vec4 fragColor;

void main() {
    vec3 color = textureProj(Sampler0, texProj0).rgb * COLORS;
    color += textureProj(Sampler0, texProj0 * tv_layer(1.0)).rgb * (COLORS);
    fragColor = vec4(color, 1.0);
}
