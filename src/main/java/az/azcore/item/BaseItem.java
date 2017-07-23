package az.azcore.item;

import az.azcore.registry.IRegisterable;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;

import static az.azcore.util.AzUtil.unlocalizedWithID;
import static az.azcore.util.ModelUtil.registerItemModel;
import static az.azcore.util.RegisterUtil.registerItem;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public abstract class BaseItem extends Item implements IRegisterable{

    public String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public BaseItem(String name, CreativeTabs creativeTab){
        setUnlocalizedName(unlocalizedWithID(name, ID));
        setRegistryName(name);
        if (creativeTab != null) { //That's not how this works. That's not how any of this works!
            setCreativeTab(creativeTab);
        }
    }

    @Override
    public void register(){
       registerItem(this);
    }

    @Override
    public void initModel(){
        registerItemModel(this);
    }
}
