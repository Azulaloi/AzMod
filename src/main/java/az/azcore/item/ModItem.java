package az.azcore.item;

import az.azcore.registry.IInitModel;
import az.azcore.registry.IRegisterable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public abstract class ModItem extends Item implements IRegisterable, IInitModel{

    public String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public ModItem(String name, CreativeTabs creativeTab){
        setUnlocalizedName(ID + "." + name);
        setRegistryName(name);
        if (creativeTab != null) {
            setCreativeTab(creativeTab);
        }
    }

    @Override
    public void register(){
        ForgeRegistries.ITEMS.register(this);
    }

    @Override
    public void initModel(){
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
                new ModelResourceLocation(getRegistryName(), "inventory")
        );
    }
}
