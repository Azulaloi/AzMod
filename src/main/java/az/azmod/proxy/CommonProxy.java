package az.azmod.proxy;


import az.azmod.registry.RegistryMaster;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by Azulaloi on 7/9/2017.
 */

//@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event){
        MinecraftForge.EVENT_BUS.register(RegistryMaster.class); //Allows RegMaster to listen to events
        RegistryMaster.init();
        /**
         * Registry Flow:
         * CommonProxy runs RegistryMaster.init during preInit
         * RegistryMaster.init does RegistryBlocks.init
         *
         * None of these actually do anything right now, all registering
         * is done through Event listeners.
         */
    }

    public void init(FMLInitializationEvent event){

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
