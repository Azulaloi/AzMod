package az.azmod.item.tools;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestHoe extends ItemHoe implements IRegisterable{
    public TestHoe(){
        super(ToolMaterial.IRON);
        setUnlocalizedName(unlocalizedWithID("testhoe", AzMod.MODID));
        setRegistryName("testhoe");
        setCreativeTab(AzMod.creativeTab);
    }

    @Override
    public void register() {
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void initModel() {
        registerItemModel(this);
    }
}
