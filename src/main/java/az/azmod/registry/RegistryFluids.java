package az.azmod.registry;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by Azulaloi on 7/13/2017.
 */
public class RegistryFluids {
    public static void doRegisters(){

        registerFluidBlocks();
    }

        public static Fluid initFluid(Fluid fluidToInit){
        FluidRegistry.registerFluid(fluidToInit);
        FluidRegistry.addBucketForFluid(fluidToInit);

        return fluidToInit;
    }

    public static void registerFluidBlocks(){

    }
}
