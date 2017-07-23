package az.azmod.block.fluid;

import az.azmod.block.ModFluids;
import net.minecraft.block.material.Material;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestFluidBlock extends ModFluidBlock {
    public TestFluidBlock() { //Implementation test of ModFluidBlock
        super(ModFluids.fluidTest, Material.WATER, "fluidtestblock");
//        setUnlocalizedName(AzMod.MODID + ".testfluidblock");
//        setRegistryName("testfluidblock");
//        setCreativeTab(AzMod.creativeTab);
    }
}
