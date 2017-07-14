package az.azmod.registry;

import az.azmod.block.ModBlocks;
import az.azmod.block.blocks.TestBlock;
import az.azmod.block.fluid.TestFluidBlock;
import az.azmod.item.TestItem;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Azulaloi on 7/12/2017.
 */
public class RegistryMaster {
    public static void init(){ //Probably better than "doRegisters".
        RegistryBlocks.init(); //They still don't actually do anything, though.
        RegistryFluids.init(); //If they're event listeners, they won't even need to be initalized
        RegistryItems.init();  //in this way, will they? Just initialized with the event bus...
    }

//    @SideOnly(Side.CLIENT)
//    public static void initClient() { RegistryRender.doRegisters(); }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().register(new TestBlock());
//        event.getRegistry().register(new TestFluidBlock());
        event.getRegistry().register(new TestFluidBlock()); //I feel like I should be getting these from ModBlocks
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        //Block items
        event.getRegistry().register(new ItemBlock(ModBlocks.testBlock).setRegistryName(ModBlocks.testBlock.getRegistryName()));

        //Just items
        event.getRegistry().register(new TestItem());
    }
}
