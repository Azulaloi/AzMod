package az.azcore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
/**
 * Created by Azulaloi on 7/17/2017.
 */

@Mod(modid = AzCore.MODID, name = AzCore.MODNAME, version = AzCore.MODVERSION, useMetadata = true)
//dependencies = "required-after:Forge@[13.19.0.2129,)",
public class AzCore {
    public static final String MODID = "azcore";
    public static final String MODNAME = "AzCore";
    public static final String MODVERSION = "0.0";

    @SidedProxy(clientSide = "az.azcore.proxy.ClientProxy")
    public static az.azcore.proxy.CommonProxy proxy;

    @Mod.Instance
    public static AzCore instance;

    public static Logger logger;

    public static CreativeTabs creativeTab = new CreativeTabs(MODID){
        @Override
            public ItemStack getTabIconItem() {
                return new ItemStack(Items.DIAMOND);
        }
    };

    static {FluidRegistry.enableUniversalBucket();}

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }


}
