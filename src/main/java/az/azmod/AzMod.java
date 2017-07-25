package az.azmod;

import az.azmod.block.ModBlocks;
import az.azmod.command.ChunkPosCommand;
import az.azmod.command.NoiseCommand;
import az.azmod.network.PacketFluidInfo;
import az.azmod.network.PacketFluidInfoRequest;
import az.azmod.proxy.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = AzMod.MODID, name = AzMod.MODNAME, version = AzMod.MODVERSION, useMetadata = true,
dependencies = "required-after:azcore@[0.0,)")
//dependencies = "required-after:Forge@[13.19.0.2129,)",
public class AzMod {
    public static final String MODID = "azmod";
    public static final String MODNAME = "AzMod";
    public static final String MODVERSION = "0.0";

    @SidedProxy(clientSide = "az.azmod.proxy.ClientProxy", serverSide = "az.azmod.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance
    public static AzMod instance;

    public static final Logger logger = LogManager.getLogger(MODID);

    public static CreativeTabs creativeTab = new CreativeTabs(MODID){
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModBlocks.testBlock);
        }
    };

    static {
        //You do it!
        //No, you do it!
        FluidRegistry.enableUniversalBucket();
    }

    public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
//    public static SimpleNetworkWrapper wrapper;
//    public static SimpleNetworkWrapper network;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
//        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(proxy);
        proxy.preInit(event);

//        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);
        network.registerMessage(new PacketFluidInfo.Handler(), PacketFluidInfo.class, 0, Side.CLIENT);
        network.registerMessage(new PacketFluidInfoRequest.Handler(), PacketFluidInfoRequest.class, 1, Side.CLIENT);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }

    @Mod.EventHandler
    public void serverLoad(FMLServerStartingEvent event){
        event.registerServerCommand(new NoiseCommand());
        event.registerServerCommand(new ChunkPosCommand());
    }


}
