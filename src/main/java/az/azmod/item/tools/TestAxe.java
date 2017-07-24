package az.azmod.item.tools;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestAxe extends ItemAxe implements IRegisterable{
    public TestAxe(){
        super(ToolMaterial.IRON);
        setUnlocalizedName(unlocalizedWithID("testaxe", AzMod.MODID));
        setRegistryName("testaxe");
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
