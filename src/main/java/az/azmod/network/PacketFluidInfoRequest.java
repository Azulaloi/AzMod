package az.azmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.UUID;

/**
 * Created by Azulaloi on 7/25/2017
 */
public class PacketFluidInfoRequest implements IMessage{
    public long pos = 0;
    UUID id = null;

    public PacketFluidInfoRequest(UUID id, BlockPos pos){
        this.pos = pos.toLong();
        this.id = id;
    }

    public PacketFluidInfoRequest(){

    }

    @Override
    public void fromBytes(ByteBuf buf) {
        id = new UUID(buf.readLong(), buf.readLong());
        pos = buf.readLong();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeLong(id.getMostSignificantBits());
        buf.writeLong(id.getLeastSignificantBits());
        buf.writeLong(pos);
    }

    public static class Handler implements IMessageHandler<PacketFluidInfoRequest, PacketFluidInfo>{

        @Override
        public PacketFluidInfo onMessage(PacketFluidInfoRequest message, MessageContext ctx) {
            BlockPos pos = BlockPos.fromLong(message.pos);
            EntityPlayer playerIn = FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayerByUUID(message.id);
            if (playerIn != null){
                if (playerIn.world != null){
                    if (playerIn.world.getTileEntity(pos) != null){
                        playerIn.world.getTileEntity(pos).markDirty();
                    }
                }
            }
            return null;
        }
    }
}
