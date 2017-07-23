package az.azcore.util;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class InventoryUtil {
    /**
     * Functionally similar to net.minecraft.inventory.InventoryHelper.dropInventoryItems
     * but works with IItemHandler, rather than IInventory
     */

    public static void dropContents(IItemHandler inv, World world, BlockPos pos){
        dropContents(inv, world, pos.getX(), pos.getY(), pos.getZ());
    }

    public static void dropContents(IItemHandler inv, World world, double x, double y, double z ){
        if (inv != null && !world.isRemote){ //Does this exist and are we the server
            for (int i = 0; i < inv.getSlots(); ++i){
                ItemStack stack = inv.getStackInSlot(i);

                if (!stack.isEmpty()){
//                    spawnItemStack(world, x, y, z, stack);

                    //Use vanilla's item spawner at this point, not
                    //currently necessary to re-implement noise functions
                    InventoryHelper.spawnItemStack(world, x, y, z, stack);
                }
            }
        }
    }


    /*
    Simple function to drop an item.
     */
    public static void spawnItemStack(World worldIn, double x, double y, double z, ItemStack stack){
        EntityItem entityitem = new EntityItem(worldIn, x, y, z, stack);
        worldIn.spawnEntity(entityitem);
    }
}
