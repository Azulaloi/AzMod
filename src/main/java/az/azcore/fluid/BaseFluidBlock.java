package az.azcore.fluid;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import az.azmod.registry.RegistryFluids;
import net.minecraft.block.material.Material;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public abstract class BaseFluidBlock extends BlockFluidClassic implements IRegisterable {
    private String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

//    public ModFluidBlock(ModFluid fluid, Material material, String name) {
//        super(fluid, material);
//        setUnlocalizedName(AzMod.MODID + "." + name);
//        setRegistryName(name);
//        setCreativeTab(AzMod.creativeTab);
//    }

    public BaseFluidBlock(Fluid fluid, Material material, String name){
        super(fluid, material);
        setUnlocalizedName(ID + ".fluid." + name);
        setRegistryName(name);
//        setRegistryName(AzMod.MODID + "." + name);
//        setCreativeTab(AzMod.creativeTab);
    }

    public BaseFluidBlock(BaseFluid fluid, Material material, String name){
        super(fluid, material);
        setUnlocalizedName(ID + ".fluid." + name);
        setRegistryName(name);
//        setRegistryName(AzMod.MODID + "." + name);
//        setCreativeTab(AzMod.creativeTab);
    }

    @Override
    public void register(){
        ForgeRegistries.BLOCKS.register(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        RegistryFluids.FluidMappingMischief map = new RegistryFluids.FluidMappingMischief(this.getFluid());
        ModelLoader.setCustomStateMapper(this, map);
    }
}
