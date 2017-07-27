package az.azmod.block.blocks.testtank;

import az.azcore.block.ModBlock;
import az.azmod.AzMod;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;

import javax.annotation.Nullable;

/**
 * Created by Azulaloi on 7/24/2017
 */
public class TestTankBlock extends ModBlock implements ITileEntityProvider {
    public TestTankBlock(){
        super("testtank", Material.GLASS, AzMod.creativeTab);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TestTankEntity();
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
                                    EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        ItemStack itemStack = player.getHeldItem(hand);
        TileEntity tileEntity = world.getTileEntity(pos);
        boolean interacted = FluidUtil.interactWithFluidHandler(player, hand, world, pos, facing);

        if (interacted){
            tileEntity.markDirty();
            return true;
        }
//        if (!world.isRemote && itemStack.isEmpty() && (((TestTankEntity) tileEntity).getFluid() != null)){
//            tileEntity.getUpdatePacket()
//        }
//        else if (world.isRemote && itemStack.isEmpty() && (((TestTankEntity) tileEntity).getFluid() != null)) {
//            player.sendMessage(new TextComponentString(((TestTankEntity) tileEntity).getFluid().getLocalizedName() + ((TestTankEntity) tileEntity).getFluidAmount()));
//            return true;
//        }
        return false;
    }
}
