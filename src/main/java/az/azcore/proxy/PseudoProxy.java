package az.azcore.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

/**
 * Created by Azulaloi on 7/17/2017.
 */

public class PseudoProxy {
    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event){
        if (event.getSide() == Side.CLIENT){
//            for (IInitModel init : ModelStorage.modelList ){
//                init.initModel();
//            }
//            ModelStorage.modelList.forEach(IInitModel::initModel); //Accidentally a lambda
        }
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
