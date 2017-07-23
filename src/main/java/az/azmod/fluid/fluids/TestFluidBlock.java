package az.azmod.fluid.fluids;

import az.azcore.fluid.BaseFluidBlock;
import az.azmod.fluid.ModFluids;
import net.minecraft.block.material.Material;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestFluidBlock extends BaseFluidBlock {
    public TestFluidBlock() { //Implementation test of ModFluidBlock
        super(ModFluids.fluidTest, Material.WATER, "fluidtestblock");
//        setUnlocalizedName(AzMod.MODID + ".testfluidblock");
//        setRegistryName("testfluidblock");
//        setCreativeTab(AzMod.creativeTab);
    }
}
