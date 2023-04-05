package base.core.glfw.windowing;

import org.joml.Vector2i;
import org.lwjgl.glfw.GLFW;

public class Window{
    private Vector2i size;
    private Vector2i position;
    private long id;
    private String title="Null";
    private Draw draw=null;
    private Process process=null;

    public long getId() { return id; }

    public Vector2i getSize() { return size; }

    public Vector2i getPosition() { return position; }

    public Window(Vector2i size,Vector2i position, long initID, String title){
        this.size=size;
        this.position=position;
        this.title=title;
        this.id=GLFW.glfwCreateWindow(this.size.x,this.size.y,this.title,0,initID);
    }

    public void setProcess(Process process){
        this.process=process;
    }
    public Process getProcess() { return process; }

    public void process(){
        if(getProcess()!=null)
            this.getProcess().process();
    }

    public void setDraw(Draw draw){
        this.draw=draw;
    }
    public Draw getDraw() { return draw; }

    public void draw(){
        if(getDraw()!=null)
            this.getDraw().draw();
    }

    public void placeWindowByCenter(Vector2i position){
        setWindowPos(new Vector2i(position).sub(new Vector2i(this.size).div(2)));
    }

    public void setWindowPos(Vector2i position){
        this.position=position;
        GLFW.glfwSetWindowPos(getId(), this.position.x, this.position.y);
    }

    public void setWindowSize(Vector2i size){
        this.size=size;
        GLFW.glfwSetWindowSize(getId(), this.size.x, this.size.y);
    }

    public void setContext(){ GLFW.glfwMakeContextCurrent(getId()); }

    public void showWindow(){ GLFW.glfwShowWindow(getId()); }

    public void hideWindow(){ GLFW.glfwHideWindow(getId()); }

    public void setLimits(Vector2i min, Vector2i max){ GLFW.glfwSetWindowSizeLimits(getId(), min.x, min.y, max.x, max.y); }

    public void setLimits(){ GLFW.glfwSetWindowSizeLimits(getId(), this.size.x, this.size.y, this.size.x, this.size.y); }

    public void destroy(){ GLFW.glfwDestroyWindow(getId()); }

    public void swapBuff(){ GLFW.glfwSwapBuffers(getId()); }

    public void focus(){ GLFW.glfwFocusWindow(getId());}
}
