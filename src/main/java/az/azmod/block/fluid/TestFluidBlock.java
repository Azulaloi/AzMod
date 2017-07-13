package az.azmod.block.fluid;

import az.azmod.AzMod;
import az.azmod.block.ModBlocks;
import az.azmod.registry.RegistryFluids;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
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
        RegistryFluids.FluidMappingMischief map = new RegistryFluids.FluidMappingMischief(ModBlocks.fluidTest);
        ModelLoader.setCustomStateMapper(this, map);
    }
}
