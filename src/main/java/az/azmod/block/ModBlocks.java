package az.azmod.block;

import az.azcore.util.ModelUtil;
import az.azcore.util.RegisterUtil;
import az.azmod.AzMod;
import az.azmod.block.blocks.TestBlock;
import az.azmod.block.blocks.TestBlockRotatable;
import az.azmod.block.blocks.testchest.TestChestBlock;
import az.azmod.block.blocks.testtank.TestTankBlock;
import az.azmod.block.blocks.testtank.TestTankEntity;
import az.azmod.fluid.ModFluids;
import az.azmod.fluid.fluids.TestFluidBlock;
import az.azmod.proxy.ClientProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Azulaloi on 7/10/2017.
 */
@Mod.EventBusSubscriber(modid = AzMod.MODID)
public class ModBlocks {
    public static TestBlock testBlock = new TestBlock("testblock", Material.ROCK);
    public static TestBlockRotatable testBlockRotatable = new TestBlockRotatable();
    public static TestChestBlock testChest = new TestChestBlock();
    public static TestFluidBlock testFluidBlock = new TestFluidBlock(ModFluids.fluidTest);
    public static TestTankBlock testTank = new TestTankBlock();

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(
            testBlock,
            testBlockRotatable,
            testChest,
            testFluidBlock,
            testTank
        );
        GameRegistry.registerTileEntity(TestTankEntity.class, AzMod.MODID + "_testtank");
    }

    @SubscribeEvent
    public static void registerBlockItems(RegistryEvent.Register<Item> event) {
        RegisterUtil.registerBlockItem(testBlock);
        RegisterUtil.registerBlockItem(testBlockRotatable);
        RegisterUtil.registerBlockItem(testChest);
        RegisterUtil.registerBlockItem(testTank);

        if (AzMod.proxy instanceof ClientProxy){
            ModelUtil.registerItemModel(Item.getItemFromBlock(testBlock));
            ModelUtil.registerItemModel(Item.getItemFromBlock(testBlockRotatable));
            ModelUtil.registerItemModel(Item.getItemFromBlock(testChest));
            ModelUtil.registerItemModel(Item.getItemFromBlock(testTank));

            testFluidBlock.initModel();
        }
    }
}
