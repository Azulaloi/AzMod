package az.azmod.block.blocks.testchest;

import az.azcore.block.ModBlock;
import az.azmod.AzMod;
import az.azcore.util.InventoryUtil;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class TestChestBlock extends ModBlock implements ITileEntityProvider
{
    public static final int GUI_ID =1;

    public TestChestBlock(){
        super("testchest", Material.WOOD, AzMod.creativeTab);
    }

//    public TestChestBlock(){
//        super(Material.WOOD);
//        setUnlocalizedName("testchest");
//        setRegistryName(AzMod.getID(), "testchest");
//        setCreativeTab(AzMod.creativeTab);
//    }

    @Override
    public void register(){
        super.register();
        GameRegistry.registerTileEntity(TestChestEntity.class, AzMod.MODID + "_testchest");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int m) {
        return new TestChestEntity();
    }

    @Override
    public boolean hasTileEntity(IBlockState state){
        return true;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
        if (worldIn.isRemote){
            return true;
        }
        TileEntity te = worldIn.getTileEntity(pos);
        if (!(te instanceof TestChestEntity)) {
            return false;
        }

        playerIn.openGui(AzMod.instance, GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state){
        TileEntity te = worldIn.getTileEntity(pos);

        if (te instanceof TestChestEntity){
            InventoryUtil.dropContents((((TestChestEntity) te).itemStackHandler), worldIn, pos);
//            ((TestChestEntity) te).breakBlock(worldIn, pos, state);
        }

        super.breakBlock(worldIn, pos, state);
    }
}
