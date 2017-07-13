package az.azmod.block.blocks;

import az.azmod.AzMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestBlock extends Block {
    public TestBlock() {
        super(Material.ROCK);
        setUnlocalizedName(AzMod.MODID + ".testblock");
        setRegistryName("testblock");
        setCreativeTab(AzMod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
