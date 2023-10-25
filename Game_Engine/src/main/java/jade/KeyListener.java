package jade;


import static org.lwjgl.glfw.GLFW.*;

public class KeyListener {
    public static KeyListener instance = null;
    private final boolean[] keyPressed = new boolean[350];
    private KeyListener(){}
    public static KeyListener get(){
        if(KeyListener.instance == null){
            KeyListener.instance = new KeyListener();
        }
        return KeyListener.instance;
    }
    public static void keyCallback(long window, int key, int scancode, int action, int mods){
        if(action == GLFW_PRESS){
            get().keyPressed[key] = true;
        }else if(action == GLFW_RELEASE){
            get().keyPressed[key] = false;
        }
    }
    public static boolean isKeyPressed(int key){
        if(key < get().keyPressed.length) {
            return get().keyPressed[key];
        }else {
            return false;
        }
    }

}
