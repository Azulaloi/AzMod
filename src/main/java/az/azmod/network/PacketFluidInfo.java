package az.azmod.network;

import az.azmod.block.blocks.testtank.TestTankEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.nio.charset.Charset;

/**
 * Created by Azulaloi on 7/25/2017
 */
public class PacketFluidInfo implements IMessage{
    private BlockPos pos;
//    private FluidStack fluid;
    private String fluid;
    private int amount;

    public PacketFluidInfo(BlockPos pos, String fluid, int amount){
        this.pos = pos;
        this.fluid = fluid;
        this.amount = amount;
    }

    public PacketFluidInfo(TestTankEntity tankEntity){
//        this(tankEntity.getPos(), tankEntity.getFluid().tag, tankEntity.getFluidAmount());
//        this(tankEntity.getPos(), tankEntity.getTileData(), tankEntity.getFluidAmount());
//        this(tankEntity.getPos(), tankEntity.serializeNBT(), tankEntity.getFluidAmount());
        this(tankEntity.getPos(), tankEntity.getFluid().getFluid().getName(), tankEntity.getFluidAmount());
//        tankEntity.getUpdatePacket();
    }

    public PacketFluidInfo(){
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
//        fluid = ByteBufUtils.readTag(buf);
        fluid = (String) buf.readCharSequence(fluid.length(), Charset.defaultCharset()); //This is wrong.
        amount = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
//        ByteBufUtils.writeTag(buf, fluid);
        buf.writeBytes(fluid.getBytes(Charset.defaultCharset())); //Wjat te fak am I dong?
//        buf.writeLong(fluid.to)
        buf.writeInt(amount);
    }

    public static class Handler implements IMessageHandler<PacketFluidInfo, IMessage>{

        @Override
        public IMessage onMessage(PacketFluidInfo message, MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                TestTankEntity tankEntity = (TestTankEntity)Minecraft.getMinecraft().world.getTileEntity(message.pos);
//                if (tankEntity != null){ tankEntity.writeToNBT(message.fluid); } //See? I'm learning!
//                tankEntity.handleUpdateTag(message.fluid);
//                if (tankEntity != null) tankEntity.readFromNBT(message.fluid);
                tankEntity.fill(FluidRegistry.getFluidStack(message.fluid, message.amount), true);
            });
            return null;
        }
    }
}
