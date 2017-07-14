package az.azmod.block.fluid;

import az.azmod.AzMod;
import az.azmod.registry.RegistryFluids;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public abstract class ModFluidBlock extends BlockFluidClassic {
    public ModFluidBlock(ModFluid fluid, Material material, String name) {
        super(fluid, material);
        setUnlocalizedName(AzMod.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(AzMod.creativeTab);
    }

    public ModFluidBlock(Fluid fluid, Material material, String name){
        super(fluid, material);
        setUnlocalizedName(AzMod.MODID + ".fluid." + name);
//        setRegistryName(AzMod.MODID + "." + name);
        setCreativeTab(AzMod.creativeTab);
    }


    @SideOnly(Side.CLIENT)
    public void initModel() {
        RegistryFluids.FluidMappingMischief map = new RegistryFluids.FluidMappingMischief(this.getFluid());
        ModelLoader.setCustomStateMapper(this, map);
    }
}
