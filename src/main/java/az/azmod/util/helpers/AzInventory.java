package az.azmod.util.helpers;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.IItemHandler;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class AzInventory {
    public static void dropContents(IItemHandler inv, World world, BlockPos pos, IBlockState state){
        if (inv != null && !world.isRemote){ //Does this exist and are we the server
            for (int i = 0; i < inv.getSlots(); ++i){
                ItemStack stack = inv.getStackInSlot(i);

                if (!stack.isEmpty()){
                    spawnItemStack(world, pos, stack);
                }
            }
        }
    }

    public static void spawnItemStack(World worldIn, BlockPos pos, ItemStack stack){
        EntityItem entityitem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
        worldIn.spawnEntity(entityitem);
    }
}
