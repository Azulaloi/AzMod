package az.azmod.registry;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by Azulaloi on 7/13/2017.
 */
public class RegistryFluids {
    public static void init(){
        registerFluidBlocks();
    }

//        public static ModFluid initFluid(ModFluid fluidToInit){
//        FluidRegistry.registerFluid(fluidToInit);
//        FluidRegistry.addBucketForFluid(fluidToInit);
//
//        return fluidToInit;
//    }

    public static void registerFluidBlocks(){

    }
//
//    public static class FluidMappingMischief extends StateMapperBase { //I'm the map, I'm the map
//        private ModelResourceLocation location;
//
//        public FluidMappingMischief(Fluid fluid){
//            this.location = new ModelResourceLocation("azmod:fluidtest");
//        }
//
//        @Override
//        public ModelResourceLocation getModelResourceLocation(IBlockState something){ return location; }
//    }
}
