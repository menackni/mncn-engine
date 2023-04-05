package base;

import base.addons.opengl.DrawGL;
import base.addons.opengl.ManagerGL;
import base.core.glfw.ManagerGLFW;
import base.core.logic.Loop;
import org.lwjgl.glfw.GLFW;

public class shortcuts{

    public static void basicSetup(){
        ManagerGLFW.getAfter().add(()->{ManagerGL.init();return false;},"OPENGL_INIT");

        ManagerGLFW.init();

        ManagerGLFW.getMainWindow().setDraw(new DrawGL(ManagerGLFW.getMainWindow()));

        Loop.setStopCondition(ManagerGLFW.getStopCondition());

        Loop.getRunning().add(()->{GLFW.glfwPollEvents();return false;},"GLFW_PULL_EVENTS");
        Loop.getDraw().add(()->{ManagerGLFW.getMainWindow().draw();return false;},"MAIN_WINDOW_DRAW");
        Loop.getRunning().add(()->{ManagerGLFW.getMainWindow().process();return false;},"MAIN_WINDOW_PROCESS");
    }

}
