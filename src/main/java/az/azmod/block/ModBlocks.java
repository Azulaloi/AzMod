package az.azmod.block;

import az.azmod.block.blocks.TestBlock;
import az.azmod.block.fluid.TestFluidBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class ModBlocks {

    /**
     * Blocks
     */
    @GameRegistry.ObjectHolder("azmod:testblock") //Creates Event
    public static TestBlock testBlock; //Creates Reference


    /**
     * Fluid Blocks
     */

    @GameRegistry.ObjectHolder("azmod:fluidtestblock") //Creates block event
    public static TestFluidBlock testFluidBlock; //Creates block reference

    /**
     * Models
     */
    @SideOnly(Side.CLIENT) //Client-side conditional
    public static void initModels(){
        testBlock.initModel();
        testFluidBlock.initModel();
    }
}
