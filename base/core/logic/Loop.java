package base.core.logic;

import base.core.glfw.ManagerGLFW;
import base.core.toolbox.SupplierMap;

import java.util.function.Supplier;

public class Loop{

    private static double logicCap=1.0/1024.0;
    private static double frameCap=1.0/128.0;
    private static double lastTimeLogic=0;
    private static double lastTimeFrame=0;

    private static Supplier<Boolean> stopCondition=()->{return true;};

    private static SupplierMap draw=new SupplierMap();
    private static SupplierMap running=new SupplierMap();
    private static SupplierMap stop=new SupplierMap();

    public static void setStopCondition(Supplier<Boolean> stopCondition){Loop.stopCondition=stopCondition;}
    public static Supplier<Boolean> getStopCondition() { return stopCondition;}

    public static SupplierMap getDraw() { return draw; }
    public static SupplierMap getRunning() { return running; }
    public static SupplierMap getStop() { return stop; }

    public static void loop(){
        while(getStopCondition().get()){
            //try { sleep(1); } catch (InterruptedException e) { }
            doStuff();
        }
        getStop().run();
    }

    private static void doStuff(){
        double currentTime=(double)System.nanoTime()/(double)1000000000L;
        if(currentTime-lastTimeLogic>logicCap){
            lastTimeLogic=currentTime;
            getRunning().run();
        }
        if(currentTime-lastTimeFrame>frameCap){
            lastTimeFrame=currentTime;
            getDraw().run();
        }
    }
}
