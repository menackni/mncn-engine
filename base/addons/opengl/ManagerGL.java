package base.addons.opengl;

import base.core.toolbox.SupplierMap;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class ManagerGL {
    private static SupplierMap before=new SupplierMap();
    private static SupplierMap after=new SupplierMap();

    public static SupplierMap getBefore() { return before; }
    public static SupplierMap getAfter() { return after; }

    public static void init(){
        System.out.println("OPENGL_INIT_START");
        getBefore().run();
        createCapabilities();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        getAfter().run();
        System.out.println("OPENGL_INIT_END");
    }

    public static void createCapabilities(){ GL.createCapabilities(); }

}
