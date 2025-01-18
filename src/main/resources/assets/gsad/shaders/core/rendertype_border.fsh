#version 150

#moj_import <minecraft:fog.glsl>

uniform sampler2D Sampler0;

in vec4 texProj0;

out vec4 fragColor;

void main() {
    vec4 color = texture(Sampler0, texProj0) * vec4(1.0, 0.0, 0.0, 1.0);
    fragColor = color;
}
