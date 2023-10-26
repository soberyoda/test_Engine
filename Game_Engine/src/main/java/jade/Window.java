package jade;

import lombok.Getter;
import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import util.Time;


import java.util.Objects;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11C.*;
import static org.lwjgl.system.MemoryUtil.NULL;

@Getter
public class Window {
    private final int width, height;
    private final String title;
    public static Window window = null;
    private long glfwWindow;
    private float r,g,b,a;
    private Window(){
        this.width = 1920;
        this.height = 1080;
        this.title ="Mario";
        r = 1;
        g = 1;
        b = 1;
        a = 1;
    }

    public static Window get(){
        if(Window.window == null){
            Window.window = new Window();
        }
        return Window.window;
    }
    public void run(){
        System.out.println("Hello LWJGL "+ Version.getVersion());
        init();
        loop();

        // free the memory
        glfwFreeCallbacks(glfwWindow);
        glfwDestroyWindow(glfwWindow);

        // terminate GLFW and free the error callback
        glfwTerminate();
        Objects.requireNonNull(glfwSetErrorCallback(null)).free();

    }
    public void init(){
        // set up the error callback
        GLFWErrorCallback.createPrint(System.err).set();

        // initialize GLFW
        if(!glfwInit()){
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFW_MAXIMIZED, GLFW_TRUE); // when the window starts it is in the maximized position

        // create the window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title,NULL, NULL); // memory address where the window is in the memory space

        if(glfwWindow == NULL){
            throw new RuntimeException("Failed to create the GLFW window");
        }

        glfwSetCursorPosCallback(glfwWindow, MouseListener::mousePosCallBack);
        glfwSetMouseButtonCallback(glfwWindow, MouseListener::mouseButtonCallback);
        glfwSetScrollCallback(glfwWindow, MouseListener::mouseScrollCallback);
        glfwSetKeyCallback(glfwWindow, KeyListener::keyCallback);

        // make the openGL context current
        glfwMakeContextCurrent(glfwWindow);

        // Enable v-sync
        glfwSwapInterval(1);

        // make the window visible
        glfwShowWindow(glfwWindow);

        GL.createCapabilities();

    }
    public void loop(){
        float beginTime = Time.getTime();
        float endTime = Time.getTime();

        while(!glfwWindowShouldClose(glfwWindow)){
            // Poll events
            glfwPollEvents();
            glClearColor(r,g,b,a);
            glClear(GL_COLOR_BUFFER_BIT);
            glfwSwapBuffers(glfwWindow);
        }
        endTime = Time.getTime();
        float dt = endTime-beginTime;
        beginTime = endTime;
    }


}
