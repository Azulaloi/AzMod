package az.azcore.block;

import az.azcore.registry.IRegisterable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class ModBlock extends Block implements IRegisterable {
    public String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public ModBlock(String name, Material material, CreativeTabs creativeTab) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(ID, name);
        setCreativeTab(creativeTab);
    }

    @Override
    public void register() {
        ForgeRegistries.BLOCKS.register(this);
        ForgeRegistries.ITEMS.register(Item.getItemFromBlock(this));

    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
    }

}
