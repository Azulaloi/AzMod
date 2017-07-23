package az.azcore.block;

import az.azcore.registry.IRegisterable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static az.azcore.util.RegisterUtil.registerBlockItem;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public abstract class ModBlock extends BaseBlock implements IRegisterable {
    private String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public ModBlock(String name, Material material, CreativeTabs creativeTab) {
        super(name, material);
        setCreativeTab(creativeTab);
    }

    @Override
    public void register() {
        super.register();
        registerBlockItem(this);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
                //Returns modid:name, which is the same format as Resource Paths
    }
}
