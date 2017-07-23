package az.azmod.block.blocks.testchest;

import jline.internal.Nullable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class TestChestContainer extends Container {
    private TestChestEntity te;

    public TestChestContainer(IInventory pI, TestChestEntity te){
        this.te = te;

        addOwnSlots();
        addPlayerSlots(pI);
    }

    private void addPlayerSlots(IInventory pI){
        /**
         * Builds player inventory:
         * 3 rows of length 9
         * 9 columns of height 3
         */
        for (int row = 0; row < 3; ++row){
            for (int column = 0; column < 9; ++column){
                int x = 9 + column * 18;
                int y = row * 18 + 70;
                this.addSlotToContainer(new Slot(pI, column + row * 9 + 10, x, y));
            }
        }

        /**
         * Builds player hotbar:
         * one row of length 9
         */
        for (int row = 0; row < 9; ++row){
            int x = 9 + row * 18;
            int y = 58 + 70;
            this.addSlotToContainer(new Slot(pI, row, x, y));
        }
    }

    private void addOwnSlots(){
        IItemHandler itemHandler = this.te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int x = 9;
        int y = 6;

        int slotIndex = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++){
            addSlotToContainer(new SlotItemHandler(itemHandler, slotIndex, x, y));
            slotIndex++;
            x += 18;
        }
    }

    @Nullable
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int in){
        ItemStack itemstack = null;
        Slot slot = this.inventorySlots.get(in);

        if (slot != null && slot.getHasStack()){
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (in < TestChestEntity.SIZE) {
                if  (!this.mergeItemStack(itemstack1, TestChestEntity.SIZE, this.inventorySlots.size(), true)){
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, TestChestEntity.SIZE, false)) {
                return null;
            }
            if (itemstack1.isEmpty()){
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player){
        return te.canInteractWith(player);
    }
}
