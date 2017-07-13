package az.azmod.registry;

import az.azmod.block.ModBlocks;
import az.azmod.block.blocks.TestBlock;
import az.azmod.block.fluid.TestFluidBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Azulaloi on 7/12/2017.
 */
public class RegistryMaster {
    public static void init(){
       RegistryBlocks.doRegisters();
    }

//    @SideOnly(Side.CLIENT)
//    public static void initClient() { RegistryRender.doRegisters(); }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().register(new TestBlock());
        event.getRegistry().register(new TestFluidBlock());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        event.getRegistry().register(new ItemBlock(ModBlocks.testBlock).setRegistryName(ModBlocks.testBlock.getRegistryName()));
    }

//    @SubscribeEvent
//    public static void registerRender(ModelRegistryEvent event){
//        TestBlock.initModel();
//    }
//    @SideOnly(Side.CLIENT)
}
