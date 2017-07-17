package az.azmod.block.blocks;

import az.azmod.AzMod;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Azulaloi on 7/17/2017.
 */
public class TestChest extends ModBlock implements ITileEntityProvider
{
    public static final int GUI_ID =1;

    public TestChest(){
        super("testchest", Material.WOOD);
    }

//    public TestChest(){
//        super(Material.WOOD);
//        setUnlocalizedName("testchest");
//        setRegistryName(AzMod.getID(), "testchest");
//        setCreativeTab(AzMod.creativeTab);
//    }

    @Override
    public TileEntity createNewTileEntity(World world, int m) {
        return new TestChestEntity();
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
}
