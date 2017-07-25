package az.azmod.network;

import az.azmod.block.blocks.testtank.TestTankEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Azulaloi on 7/25/2017
 */
public class PacketFluidInfo implements IMessage{
    private BlockPos pos;
//    private FluidStack fluid;
    private NBTTagCompound fluid;
    private int amount;

    public PacketFluidInfo(BlockPos pos, NBTTagCompound fluid, int amount){
        this.pos = pos;
        this.fluid = fluid;
        this.amount = amount;
    }

    public PacketFluidInfo(TestTankEntity tankEntity){
        this(tankEntity.getPos(), tankEntity.getFluid().tag, tankEntity.getFluidAmount());
//        tankEntity.getUpdatePacket();
    }

    public PacketFluidInfo(){
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        fluid = ByteBufUtils.readTag(buf);
        amount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        ByteBufUtils.writeTag(buf, fluid);
        buf.writeInt(amount);
    }

    public static class Handler implements IMessageHandler<PacketFluidInfo, IMessage>{

        @Override
        public IMessage onMessage(PacketFluidInfo message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TestTankEntity tankEntity = (TestTankEntity)Minecraft.getMinecraft().world.getTileEntity(message.pos);
//                if (tankEntity != null){ tankEntity.writeToNBT(message.fluid); } //See? I'm learning!
//                tankEntity.handleUpdateTag(message.fluid);
                if (tankEntity != null) tankEntity.readFromNBT(message.fluid);
            });
            return null;
        }
    }
}
