package az.azmod.item.tools;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestShovel extends ItemSpade implements IRegisterable{
    public TestShovel(){
        super(ToolMaterial.IRON);
        setUnlocalizedName(unlocalizedWithID("testshovel", AzMod.MODID));
        setRegistryName("testshovel");
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
