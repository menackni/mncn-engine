package base.core.glfw.windowing;

import base.core.toolbox.SupplierMap;
import org.lwjgl.glfw.GLFW;

public class Process{
    private Window window;

    private boolean STOP=false;

    private SupplierMap processes=new SupplierMap();

    public void setWindow(Window window){
        this.window=window;
    }

    public void setSTOP(boolean bool){
        this.STOP=bool;
    }
    public boolean isSTOP(){ return STOP; }

    public SupplierMap getProcesses() { return processes; }

    public Process(Window window){
        setWindow(window);
    }

    public void process(){
        if(!isSTOP()) {
            getProcesses().run();
        }
    }

}
