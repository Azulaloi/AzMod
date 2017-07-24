package az.azmod.item.tools;

import az.azcore.registry.IRegisterable;
import az.azmod.AzMod;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;

public class TestSword extends ItemSword implements IRegisterable{
    public TestSword(){
        super(ToolMaterial.IRON);
        setUnlocalizedName(unlocalizedWithID("testsword",AzMod.MODID));
        setRegistryName("testsword");
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
