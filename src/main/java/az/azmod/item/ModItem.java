package az.azmod.item;

import az.azmod.AzMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public abstract class ModItem extends Item {
    public ModItem(String name){
        setUnlocalizedName(AzMod.MODID + "." + name);
        setRegistryName(name);
        setCreativeTab(AzMod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(getRegistryName(), "inventory")
        );
    }
}
