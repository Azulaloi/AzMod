package az.azmod.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public class ModItems {
    @GameRegistry.ObjectHolder("azmod:testitem")
    public static TestItem testItem;

    @SideOnly(Side.CLIENT) //Client-side conditional
    public static void initModels(){
        testItem.initModel();
    }
}
