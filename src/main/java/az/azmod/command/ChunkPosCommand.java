package az.azmod.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;

/**
 * Created by Azulaloi on 7/24/2017
 */
public class ChunkPosCommand extends CommandBase {

    public int getRequiredPermissionLevel() {
        return 2;
    }

    @Override
    @Nonnull
    public String getName() {
        return "chunkpos";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "chunkpos";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 3) {
            BlockPos pos = sender.getPosition();

            ChunkPos cPos = new ChunkPos(pos);
            sender.sendMessage(new TextComponentString(cPos.toString()));

        }
    }
}
