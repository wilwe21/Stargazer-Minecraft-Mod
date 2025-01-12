#version 150

uniform sampler3D Sampler0;

in vec3 texCoord;

uniform float InverseAmount;

out vec4 fragColor;

void main(){
    vec4 diffuseColor = texture(Sampler0, texCoord);
    vec4 invertColor = 1.0 - diffuseColor;
    vec4 outColor = mix(diffuseColor, invertColor, InverseAmount);
    fragColor = vec4(outColor.rgb, 1.0);
}
