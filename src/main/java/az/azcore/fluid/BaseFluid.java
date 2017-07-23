package az.azcore.fluid;

import az.azmod.AzMod;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Loader;

import static az.azcore.util.AzUtil.unlocalizedWithID;

/**
 * Created by Azulaloi on 7/12/2017.
 */
public abstract class BaseFluid extends Fluid {
    private String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    //While this is currently functionally identical to implementing Fluid,
    //this class should allow me to implement other features in the future.
    public BaseFluid(String name, ResourceLocation still, ResourceLocation flowing) {
        super(name, still, flowing);
        setUnlocalizedName(unlocalizedWithID(name, ID));

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
