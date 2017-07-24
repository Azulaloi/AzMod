package az.azcore.util;

import net.minecraftforge.fluids.Fluid;

public class AzUtil {
    public static String unlocalizedWithID(String name, String id){
        return(id + "." + name);
    }

    public static String fluidBlockName(Fluid fluid){
        return(fluid.getUnlocalizedName() + "block");
    }

}
