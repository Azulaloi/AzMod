package az.azmod.proxy;

import az.azmod.block.ModBlocks;
import az.azmod.item.ModItems;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Azulaloi on 7/9/2017.
 */

public class ClientProxy extends CommonProxy {
    @Override
    public void  preInit(FMLPreInitializationEvent event){
        super.preInit(event);
        ModItems.initModels();
        ModBlocks.initModels();
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
}
