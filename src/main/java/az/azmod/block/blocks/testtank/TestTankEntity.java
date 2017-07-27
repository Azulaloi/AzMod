package az.azmod.block.blocks.testtank;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.TileFluidHandler;

import javax.annotation.Nullable;

/**
 * Created by Azulaloi on 7/24/2017
 */
public class TestTankEntity extends TileFluidHandler {
    protected FluidTank tank = new FluidTank(Fluid.BUCKET_VOLUME);

    public TestTankEntity(){
        super();
        tank.setTileEntity(this);
//        tank.set
    }

    public Fluid getFluid(){
        if (tank.getFluid() != null){
            return tank.getFluid().getFluid(); //.getFluid
        }
        return null;
    }

    @Override
    public NBTTagCompound getUpdateTag(){
        return writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket(){
        return new SPacketUpdateTileEntity(getPos(), 0, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity packet){
        readFromNBT(packet.getNbtCompound());
    }

    public void markForUpdate(){

    }

    @Override
    public void markDirty(){
        markForUpdate();
        super.markDirty();
    }
}

