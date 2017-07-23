package az.azmod.fluid;

import az.azcore.fluid.BaseFluid;
import az.azcore.util.RegisterUtil;
import net.minecraft.util.ResourceLocation;

public class ModFluids {
    public static BaseFluid fluidTest; //Creates fluid reference

    static{
        fluidTest = RegisterUtil.registerFluid(new BaseFluid( //Defines fluid object as new object created by initFluid in RegistryFluids
                "fluidtest", //Fluid name
//                az.azcore.util.AzUtil.unlocalizedWithID("fluidtest", AzMod.MODID),
                new ResourceLocation("azmod:blocks/fluids/fluidtest_still"), //Still resource
                new ResourceLocation("azmod:blocks/fluids/fluidtest_flowing") //Flowing resource
        ){}
        );
    }
}
