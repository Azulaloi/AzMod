package az.azmod.proxy;

import az.azmod.block.ModBlocks;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Azulaloi on 7/9/2017.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void  preInit(FMLPreInitializationEvent event){
        super.preInit(event);
//        RegistryMaster.initClient();
    }

    @Override
    public void init(FMLInitializationEvent event){
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event){
        super.postInit(event);
//        ModBlocks.initItemModels();
    }

    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event){
        ModBlocks.initModels();
//        ModItems.initModels();
    }
}
