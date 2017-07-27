package az.azmod.network;

import az.azmod.AzMod;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Azulaloi on 7/26/2017
 */
public class PacketUpdater {
    public static Map<BlockPos, TileEntity> updateNeeded = new HashMap<BlockPos, TileEntity>();

    public static void setUpdateNeeded(BlockPos pos, TileEntity entity){
        if(!updateNeeded.containsKey(pos)){
            updateNeeded.put(pos, entity);
        } else {
            updateNeeded.replace(pos, entity);
        }
    }

    @SubscribeEvent
    public void tick(TickEvent.WorldTickEvent event){
        if (!event.world.isRemote && event.phase == TickEvent.Phase.END){
            NBTTagList tags = new NBTTagList();
            TileEntity[] updateArray = updateNeeded.values().toArray(new TileEntity[updateNeeded.size()]);
            for (int i = 0; i < updateArray.length; i++){
                TileEntity tile = updateArray[i];
                if (!event.world.isRemote){
                    tags.appendTag(tile.getUpdateTag());
                }
            }
            if (!tags.hasNoTags()){
                NBTTagCompound tag = new NBTTagCompound();
                tag.setTag("data", tags);
                AzMod.network.sendToAll(new PacketFluidInfo(tag));
            }
            updateNeeded.clear();
        }
    }
}
