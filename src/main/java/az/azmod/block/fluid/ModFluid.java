package az.azmod.block.fluid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Azulaloi on 7/12/2017.
 */
public class ModFluid extends Fluid {
    public static ResourceLocation Still = new ResourceLocation("azmod:blocks/fluids/fluidtest_still");
    public static ResourceLocation Flowing = new ResourceLocation("azmod:blocks/fluids/fluidtest_flowing");

    public ModFluid() {
        super("fluidTest", Still, Flowing);
        setLuminosity(15);
    }
}
