package az.azcore.util;

import az.azcore.fluid.BaseFluid;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class RegisterUtil {

    public static void registerBlock(Block block){
        ForgeRegistries.BLOCKS.register(block);

    }

    public static void registerBlockItem(Block block){
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }

    public static void registerItem(Item item){
        ForgeRegistries.ITEMS.register(item);
    }

    public static BaseFluid registerFluid(BaseFluid fluidToInit){
        FluidRegistry.registerFluid(fluidToInit);
        FluidRegistry.addBucketForFluid(fluidToInit);

        return fluidToInit;
    }
}
