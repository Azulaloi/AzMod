package az.azmod.block;

import az.azcore.registry.IRegisterable;
import az.azmod.block.blocks.TestBlock;
import az.azmod.block.blocks.TestBlockRotatable;
import az.azmod.block.blocks.TestChest;
import az.azmod.block.fluid.TestFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class ModBlocks {
    public static void preInit(){
        testBlock = new TestBlock("testblock", Material.ROCK);

        registerables.add(testBlock);

        for (IRegisterable registerable : registerables) {
            registerable.register();
        }
    }

    private static ArrayList<IRegisterable> registerables = new ArrayList<>();

    public static TestBlock testBlock;

    @SideOnly(Side.CLIENT) //Client-side conditional
    public static void initModels(){
        for(IRegisterable registerable : registerables){
            registerable.initModel();
        }
    }

    /**
     * Blocks
     */


    @GameRegistry.ObjectHolder("azmod:testblockrotatable")
    public static TestBlockRotatable testBlockRotatable;

    @GameRegistry.ObjectHolder("azmod:testchest")
    public static TestChest testChest;

    /**
     * Fluid Blocks
     */

    @GameRegistry.ObjectHolder("azmod:fluidtestblock") //Creates block event
    public static TestFluidBlock testFluidBlock; //Creates block reference

    /**
     * Models
     */
//    @SideOnly(Side.CLIENT) //Client-side conditional
//    public static void initModels(){
//        testBlock.initModel();
//        testBlockRotatable.initModel();
//        testFluidBlock.initModel();
//        testChest.initModel();
//    }
}
