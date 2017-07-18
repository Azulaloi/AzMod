package az.azcore.proxy;

import az.azcore.registry.IInitModel;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

/**
 * Created by Azulaloi on 7/17/2017.
 */
//@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);

        for (IInitModel init : modelList ){
            init.initModel();
        }
    }

    public boolean addModel(IInitModel model){
        return modelList.add(model);
    }
    private static ArrayList<IInitModel> modelList = new ArrayList<>();

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }
}
