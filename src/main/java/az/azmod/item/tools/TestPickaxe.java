package az.azmod.item.tools;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestPickaxe extends ItemPickaxe implements IRegisterable{
    public TestPickaxe(){
        super(ToolMaterial.IRON);
        setUnlocalizedName(unlocalizedWithID("testpickaxe",AzMod.MODID));
        setRegistryName("testpickaxe");
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
