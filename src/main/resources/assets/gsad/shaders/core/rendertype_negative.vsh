#version 150

in vec4 Position;

uniform mat4 ProjMat;
uniform mat4 ModelViewMat;

out vec3 texCoord;

void main(){
    vec4 outPos = ModelViewMat * ProjMat * vec4(Position.xyz, 1.0);
    gl_Position = vec4(outPos.xyz, 1.0);

    texCoord = Position.xyz;
}
