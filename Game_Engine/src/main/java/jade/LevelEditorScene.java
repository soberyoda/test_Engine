package jade;

import static org.lwjgl.opengl.GL20.*;

public class LevelEditorScene extends Scene {
    private String vertexShaderSource = """
            #version 330 core
            layout (location=0) in vec3 aPos;
            layout (location=1) in vec4 aColor;

            out vec4 fColor;

            void main(){
                fColor = aColor;
                gl_Position = vec4(aPos, 1.0);
            }""";
    private String fragmentShaderSource = """
            #version 330 core

            in vec4 fColor;
            out vec4 color;

            void main(){
                fColor = color;
            }""";

    private int vertexID, fragmentID, shaderProgram;

    public LevelEditorScene(){
    }
    @Override
    public void init(){
        // Compile and link shaders
        vertexID = glCreateShader(GL_VERTEX_SHADER);
        fragmentID = glCreateShader(GL_VERTEX_SHADER);
        // pass the shader source to the GPU
        glShaderSource(vertexID, fragmentShaderSource);
        glCompileShader(vertexID);

        glShaderSource(fragmentID, fragmentShaderSource);
        glCompileShader(fragmentID);

        // check for errors in compilation
        int success = glGetShaderi(vertexID, GL_COMPILE_STATUS);
        int success2 = glGetShaderi(fragmentID, GL_COMPILE_STATUS);
        if(success == GL_FALSE) {
            int len = glGetShaderi(vertexID, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: 'defaultShader.glsl'\n\tVertex shader compilation failed");
            System.out.println(glGetShaderInfoLog(vertexID, len));
            assert false: "";
        } else if (success2 == GL_FALSE) {
            int len2 = glGetShaderi(fragmentID, GL_INFO_LOG_LENGTH);
            System.out.println("ERROR: 'defaultShader.glsl'\n\tFragment shader compilation failed");
            System.out.println(glGetShaderInfoLog(vertexID, len2));
            assert false: "";
        }
        // link shaders and check for errors

    }

    @Override
    public void update(float dt){

    }
}
