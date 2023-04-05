package base.core.glfw;

import base.core.glfw.windowing.Window;
import base.core.logic.Loop;
import base.core.toolbox.SupplierMap;
import org.joml.Vector2i;
import org.lwjgl.glfw.GLFW;

import java.util.function.Supplier;

// how it supposed to work
// we have 2 supplier arrays
// one for code before glfw init
// and one for code after glfw init (openGL for example needs to be initialized after GLFW)
// we populate these arrays before call init()
// i made this to allow extensions (that suppose to be automatically scanned before init)
// add some stuff to initialization process
// or even remove or replace some init parts
// this concept will be applied on several parts of engine (like openGL, loop, input, etc...)

public class ManagerGLFW{

    private static Supplier<Boolean> stopCondition=()->{return !GLFW.glfwWindowShouldClose(getMainWindow().getId());};

    private static Window mainWindow;

    private static SupplierMap before=new SupplierMap();
    private static SupplierMap after=new SupplierMap();

    public static Supplier<Boolean> getStopCondition(){return stopCondition;}
    public static Window getMainWindow(){return mainWindow;}

    public static SupplierMap getBefore() { return before; } //calls before glfw init
    public static SupplierMap getAfter() { return after; } //calls after glfw init

    public static void init(){
        System.out.println("GLFW_INIT_START");
        getBefore().run();

        if(GLFW.glfwInit()!=true){
            System.err.println("INIT_GLFW_WINDOW_FAILED");
            System.exit(1);
        }
        mainWindow=new Window(new Vector2i(200),new Vector2i(20),0,"main");

        getMainWindow().setLimits();
        getMainWindow().showWindow();
        getMainWindow().setContext();

        Loop.getRunning().add(()->{
            getMainWindow().setContext();
            getMainWindow().swapBuff();
            return false;
        },"GLFW_SWAP");

        getAfter().run();
        System.out.println("GLFW_INIT_END");
    }
}
