package az.azmod;

import az.azmod.block.ModBlocks;
import az.azmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;



@Mod(modid = AzMod.MODID, name = AzMod.MODNAME, version = AzMod.MODVERSION, useMetadata = true)
//dependencies = "required-after:Forge@[13.19.0.2129,)",
public class AzMod {
    public static final String MODID = "azmod";
    public static final String MODNAME = "A Test";
    public static final String MODVERSION = "0.0";

    @SidedProxy(clientSide = "az.azmod.proxy.ClientProxy", serverSide = "az.azmod.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AzMod instance;

    public static Logger logger;

//    public static CreativeTabs creativeTab;

    public static String getID(){
        return MODID;
    }

    public static CreativeTabs creativeTab = new CreativeTabs(MODID){
        @Override
            public ItemStack getTabIconItem() {
//            return new ItemStack(Items.DIAMOND);
            return new ItemStack(ModBlocks.testBlock);
        }
    };

    static {
        FluidRegistry.enableUniversalBucket();
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);

//        creativeTab = new CreativeTabs(MODID){@Override getTabIconItem(){}
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
