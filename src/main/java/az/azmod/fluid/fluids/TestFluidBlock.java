package az.azmod.fluid.fluids;

import az.azcore.fluid.BaseFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fluids.Fluid;

import static az.azcore.util.AzUtil.fluidBlockName;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestFluidBlock extends BaseFluidBlock {
    public TestFluidBlock(Fluid fluid) { //Implementation test of ModFluidBlock
        super(fluid, Material.WATER, fluidBlockName(fluid));
//        setUnlocalizedName(AzMod.MODID + ".testfluidblock");
//        setRegistryName("testfluidblock");
//        setCreativeTab(AzMod.creativeTab);
    }
}
