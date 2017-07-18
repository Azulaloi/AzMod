package az.azmod.proxy;

import az.azcore.proxy.PseudoProxy;
import az.azmod.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import static az.azmod.AzMod.instance;

/**
 * Created by Azulaloi on 7/9/2017.
 */

//@Mod.EventBusSubscriber
public class CommonProxy extends PseudoProxy{

    @Override
    public void preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        ModItems.preInit();
    }

    @Override
    public void init(FMLInitializationEvent event){
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiProxy());

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}
