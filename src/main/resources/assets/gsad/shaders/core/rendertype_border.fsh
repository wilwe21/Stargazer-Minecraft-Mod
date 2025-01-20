#version 150

#moj_import <minecraft:fog.glsl>

uniform sampler2D Sampler0;

in vec4 texProj0;

out vec4 fragColor;

void main() {
    fragColor = vec4(1.0, 0.0, 0.0, 1.0);
}
