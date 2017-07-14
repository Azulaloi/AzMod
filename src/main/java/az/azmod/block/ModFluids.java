package az.azmod.block;

import az.azmod.block.fluid.ModFluid;
import az.azmod.registry.RegistryFluids;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Azulaloi on 7/13/2017.
 */
public class ModFluids {
    public static ModFluid fluidTest; //Creates fluid reference

    static{
        fluidTest = RegistryFluids.initFluid(new ModFluid( //Defines fluid object as new object created by initFluid in RegistryFluids
                "fluidtest", //Fluid name
                new ResourceLocation("azmod:blocks/fluids/fluidtest_still"), //Still resource
                new ResourceLocation("azmod:blocks/fluids/fluidtest_flowing") //Flowing resource
        ));
    }


}
