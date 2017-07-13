package az.azmod.block;

import az.azmod.block.blocks.TestBlock;
import az.azmod.block.fluid.TestFluidBlock;
import az.azmod.registry.RegistryFluids;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */

public class ModBlocks {

    @GameRegistry.ObjectHolder("azmod:testblock") //Creates Event
    public static TestBlock testBlock; //Creates Reference



    //Fluid stuff
    public static Fluid fluidTest; //Creates fluid object

    @GameRegistry.ObjectHolder("azmod:testfluidblock") //Creates block event
    public static TestFluidBlock testFluidBlock; //Creates block reference

    static{
        fluidTest = RegistryFluids.initFluid(new Fluid( //Defines fluid object as new object created by initFluid in RegistryFluids
                "fluidTest", //Fluid name
                new ResourceLocation("azmod:blocks/fluids/fluidtest_still"), //Still resource
                new ResourceLocation("azmod:blocks/fluids/fluidtest_flowing") //Flowing resource
                ));
    }

    @SideOnly(Side.CLIENT) //Client-side conditional
    public static void initModels(){
        testBlock.initModel();
        testFluidBlock.initModel();
//        Model

    }
}
