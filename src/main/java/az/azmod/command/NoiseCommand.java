package az.azmod.command;

import az.azcore.util.AzUtil;
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

    public int getRequiredPermissionLevel() {
        return 2;
    }


    @Override
    @Nonnull
    public String getName() {
        return "noise";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "noise <x> <y> <z>";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length < 3) {
            BlockPos pos = sender.getPosition();

            sender.sendMessage(new TextComponentString("Without Octaves: " + Double.toString(AzUtil.rounder(
                    PerlinNoise.noise(
                            pos.getX() + 0.01,
                            pos.getZ() + 0.01,
                            1), 7))
            ));


            sender.sendMessage(new TextComponentString("With Octaves: " + Double.toString(AzUtil.rounder(
                    PerlinNoise.OctavePerlin(pos.getX() + 0.01,
                                             pos.getZ() + 0.01,
                                             10.01,
                                             3,
                                             3), 7))
            ));


        }
    }
}
