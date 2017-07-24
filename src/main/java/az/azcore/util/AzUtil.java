package az.azcore.util;

import net.minecraftforge.fluids.Fluid;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class AzUtil {
    public static String unlocalizedWithID(String name, String id){
        return(id + "." + name);
    }

    public static String fluidBlockName(Fluid fluid){
        return(fluid.getUnlocalizedName() + "block");
    }

    public static double rounder(double value, int places){
        if  (places < 0) throw new IllegalArgumentException("az.AzCore.util.AzUtil.rounder(double, int): Second value must be above zero");

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
