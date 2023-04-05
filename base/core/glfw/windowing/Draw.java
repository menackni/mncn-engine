package base.core.glfw.windowing;

import base.core.toolbox.SupplierMap;

public class Draw{
    private Window window;

    private boolean STOP=false;

    public void setWindow(Window window){
        this.window=window;
    }

    public void setSTOP(boolean bool){
        this.STOP=bool;
    }
    public boolean isSTOP(){ return STOP; }

    private SupplierMap start=new SupplierMap();
    private SupplierMap inside=new SupplierMap();
    private SupplierMap close=new SupplierMap();

    public SupplierMap getStart() { return start; }
    public SupplierMap getInside() { return inside; }
    public SupplierMap getClose() { return close; }


    public Window getWindow() { return window; }

    public Draw(Window window){
        setWindow(window);
    }

    public void draw(){
        if(!isSTOP()) {
            getStart().run();
            getInside().run();
            getClose().run();
        }
    }
}
