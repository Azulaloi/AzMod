package az.azmod.proxy;

import az.azmod.item.ModItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Azulaloi on 7/9/2017.
 */

public class ClientProxy extends CommonProxy {
    @Override
    public void  preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        ModItems.initModels();
//        RegistryMaster.initClient();
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
//        ModBlocks.initModels();
//        ModItems.initModels();
    }
}
