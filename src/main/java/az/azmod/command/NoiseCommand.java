package az.azmod.command;

import az.azmod.util.PerlinNoise;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

import javax.annotation.Nonnull;

/**
 * Created by Azulaloi on 7/24/2017
 */
public class NoiseCommand extends CommandBase {
    @Override
    @Nonnull
    public String getName(){
        return "noise";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "noise <x> <y> <z>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 3){
            BlockPos pos = sender.getPosition();
            sender.sendMessage(new TextComponentString(Double.toString(PerlinNoise.noise(pos.getX() + 0.01,
                                                                                         pos.getY() + 0.01,
                                                                                         pos.getZ() + 0.01))
            ));
        }

    }


}
