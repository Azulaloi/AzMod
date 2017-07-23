package az.azmod.block;

import az.azcore.registry.IRegisterable;
import az.azmod.block.blocks.TestBlock;
import az.azmod.block.blocks.TestBlockRotatable;
import az.azmod.block.blocks.testchest.TestChestBlock;
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

    private static ArrayList<IRegisterable> registerables = new ArrayList<>();

    public static void preInit(){
        testBlock = new TestBlock("testblock", Material.ROCK);
        testBlockRotatable = new TestBlockRotatable();
        testChest = new TestChestBlock();

        registerables.add(testBlock);
        registerables.add(testBlockRotatable);
        registerables.add(testChest);

        for (IRegisterable registerable : registerables) {
            registerable.register();
        }
    }

    public static TestBlock testBlock;
    public static TestBlockRotatable testBlockRotatable;
    public static TestChestBlock testChest;

    @SideOnly(Side.CLIENT) //Client-side conditional
    public static void initModels(){
        for(IRegisterable registerable : registerables){
            registerable.initModel();
        }
    }

    /**
     * Blocks
     */

//
//    @GameRegistry.ObjectHolder("azmod:testblockrotatable")
//    public static TestBlockRotatable testBlockRotatable;

//    @GameRegistry.ObjectHolder("azmod:testchest")
//    public static TestChestBlock testChest;

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
