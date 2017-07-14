package az.azmod.block.fluid;

import az.azmod.AzMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Azulaloi on 7/12/2017.
 */
public class ModFluid extends Fluid {

    //While this is currently functionally identical to implementing Fluid,
    //this class should allow me to implement other features in the future.
    public ModFluid(String name, ResourceLocation still, ResourceLocation flowing) {
        super(AzMod.MODID + "." + name, still, flowing);

//        setLuminosity(15);
//        setDensity();
//        setEmptySound();
//        setFillSound();
//        setGaseous();
//        setRarity();
//        setTemperature();
//        setViscosity();
//        setUnlocalizedName();
    }
}
