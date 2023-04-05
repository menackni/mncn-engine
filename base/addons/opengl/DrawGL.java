package base.addons.opengl;

import base.core.glfw.windowing.Draw;
import base.core.glfw.windowing.Window;
import org.lwjgl.opengl.GL11;

//this is example class that i use if forget how it suppose to work

public class DrawGL extends Draw {

    public DrawGL(Window window){
        super(window);
    }

    @Override
    public void draw(){
        if(!isSTOP()) {
            getStart().run();

            GL11.glClearColor(0, 0, 0, 0);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D,0);
            GL11.glColor4f(1,1,1,1);

            getInside().run();

            getClose().run();
        }
    }
}
