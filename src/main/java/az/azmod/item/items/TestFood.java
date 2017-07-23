package az.azmod.item.items;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestFood extends ItemFood implements IRegisterable {
    public TestFood(){
        super(4, 0.5f, false);
        setUnlocalizedName(unlocalizedWithID("testfood", AzMod.MODID));
        setRegistryName("testfood");
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
