package az.azcore.registry;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public interface IRegisterable{
    void register();

    @SideOnly(Side.CLIENT)
    void initModel();
}
