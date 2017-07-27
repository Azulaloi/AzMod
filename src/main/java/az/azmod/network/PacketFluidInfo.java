package az.azmod.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/25/2017
 */
public class PacketFluidInfo implements IMessage{
    private NBTTagCompound tagCompound;


    public PacketFluidInfo(NBTTagCompound tagCompound){
        this.tagCompound = tagCompound;
    }

    public PacketFluidInfo(){
        //Forge bullshittery
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        tagCompound = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, tagCompound);
    }

    public static class Handler implements IMessageHandler<PacketFluidInfo, IMessage>{
        @SideOnly(Side.CLIENT)
        @Override
        public IMessage onMessage(final PacketFluidInfo message, final MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                NBTTagList tags = message.tagCompound.getTagList("data", Constants.NBT.TAG_COMPOUND);
                for (int i = 0; i < tags.tagCount(); i++){
                    NBTTagCompound tag = tags.getCompoundTagAt(i);
                    TileEntity entity = Minecraft.getMinecraft().player.getEntityWorld().getTileEntity(new BlockPos(tag.getInteger("x"), tag.getInteger("y"), tag.getInteger("z")));
                    if (entity != null){
                        entity.readFromNBT(tag);
                        entity.markDirty();
                    }
                }
            });
            return null;
        }
    }
}
