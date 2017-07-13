package az.azmod.block.fluid;

import az.azmod.AzMod;
import az.azmod.block.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestFluidBlock extends BlockFluidClassic {
    public TestFluidBlock() {
        super(ModBlocks.fluidTest, Material.WATER);
        setUnlocalizedName(AzMod.MODID + ".testfluidblock");
        setRegistryName("testfluidblock");
        setCreativeTab(AzMod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        TestFluidBlock.FluidMappingMischief map = new TestFluidBlock.FluidMappingMischief(ModBlocks.fluidTest);
        ModelLoader.setCustomStateMapper(this, map);
    }

    public static class FluidMappingMischief extends StateMapperBase {
        private ModelResourceLocation whyIsThisSoHard;

        public FluidMappingMischief(Fluid fluid){
            this.whyIsThisSoHard = new ModelResourceLocation("azmod:fluidtest");
        }

        @Override
        public ModelResourceLocation getModelResourceLocation(IBlockState unendingWrath){ return whyIsThisSoHard; }
    }
}
