package az.azcore.util;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RegisterUtil {

    public static void registerBlock(Block block){
        ForgeRegistries.BLOCKS.register(block);

    }

    public static void registerBlockItem(Block block){
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
}
