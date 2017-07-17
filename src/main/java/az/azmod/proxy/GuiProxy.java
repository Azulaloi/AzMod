package az.azmod.proxy;

import az.azmod.block.blocks.TestChestContainer;
import az.azmod.block.blocks.TestChestEntity;
import az.azmod.block.blocks.TestChestGui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class GuiProxy implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TestChestEntity){
            return new TestChestContainer(player.inventory, (TestChestEntity) te);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TestChestEntity){
            TestChestEntity chestEntity = (TestChestEntity) te;
            return new TestChestGui(chestEntity, new TestChestContainer(player.inventory, chestEntity));
        }
        return null;
    }
}
