package az.azmod.registry;

import az.azmod.AzMod;
import az.azmod.block.ModBlocks;
import az.azmod.block.blocks.TestBlockRotatable;
import az.azmod.block.blocks.testchest.TestChestBlock;
import az.azmod.block.blocks.testchest.TestChestEntity;
import az.azmod.block.fluid.TestFluidBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
//        event.getRegistry().register(new TestBlock());
        event.getRegistry().register(new TestBlockRotatable());
        event.getRegistry().register(new TestFluidBlock()); //I feel like I should be getting these from ModBlocks

        //TileEntities and their Blocks
        event.getRegistry().register(new TestChestBlock());
        GameRegistry.registerTileEntity(TestChestEntity.class, AzMod.MODID + "_testchest");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event){
        //Block items
        event.getRegistry().register(new ItemBlock(ModBlocks.testBlock).setRegistryName(ModBlocks.testBlock.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.testBlockRotatable).setRegistryName(ModBlocks.testBlockRotatable.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.testChest).setRegistryName(ModBlocks.testChest.getRegistryName()));
        //Just items
//        event.getRegistry().register(new TestItem());
    }
}
