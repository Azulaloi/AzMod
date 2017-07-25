package az.azmod.network;

import az.azmod.AzMod;
import az.azmod.block.blocks.testtank.TestTankEntity;
import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.apache.logging.log4j.Level;

/**
 * Created by Azulaloi on 7/25/2017
 */
public class PacketFluidInfoRequest implements IMessage{
    private BlockPos pos;
    private int dim;

    public PacketFluidInfoRequest(BlockPos pos, int dim){
        this.pos = pos;
        this.dim = dim;
    }

    public PacketFluidInfoRequest(TestTankEntity tankEntity){
        this(tankEntity.getPos(), tankEntity.getWorld().provider.getDimension());
    }

    public PacketFluidInfoRequest(){
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        pos = BlockPos.fromLong(buf.readLong());
        dim = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(pos.toLong());
        buf.writeInt(dim);
    }

    public static class Handler implements IMessageHandler<PacketFluidInfoRequest, PacketFluidInfo>{

        @Override
        public PacketFluidInfo onMessage(PacketFluidInfoRequest message, MessageContext ctx) {
//            World world = FMLCommonHandler.instance().getMinecraftServerInstance().worldServerForDimension(message.dim);
            World world = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(message.dim);
            TestTankEntity tankEntity = (TestTankEntity)world.getTileEntity(message.pos);
            if(tankEntity != null){
                return new PacketFluidInfo(tankEntity);
            } else {
                AzMod.logger.log(Level.ERROR, "Attempted to request packet from TestTankEntity at" + message.pos + "in dimension" + message.dim + ", but it doesn't exist!"); //make this a verbose only log
                return null;
            }
        }
    }
}
