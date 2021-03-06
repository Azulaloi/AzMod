package az.azmod.block.blocks;

import az.azmod.AzMod;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.IStateMapper;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestLeaves extends BlockLeaves { //TODO: make them not decay when attached to the logs
    public static final PropertyBool DECAYABLE = PropertyBool.create("decayable");
    public static final PropertyBool CHECK_DECAY = PropertyBool.create("check_decay");

    public TestLeaves() {
        this.setUnlocalizedName("leavessilvermaple");
        this.setRegistryName("leavessilvermaple");
        this.setCreativeTab(AzMod.creativeTab);
        this.setHardness(0.2F);
        this.setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, true)); //create bools
    }

    @Override
    public List<ItemStack> onSheared(@Nonnull ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
        return Lists.newArrayList(new ItemStack(Item.getItemFromBlock(this), 1)); //DROP ME
    }

    @Override
    public BlockPlanks.EnumType getWoodType(int meta) {
        return null; //laying in wait to strike when you least expect
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return Blocks.LEAVES.isOpaqueCube(state); //I don't know, ask LEAVES.
    }

    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer(){
        return Blocks.LEAVES.getBlockLayer(); //I said I don't know!
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState state, IBlockAccess access, BlockPos pos, EnumFacing facing){
        return Blocks.LEAVES.shouldSideBeRendered(state, access, pos, facing); //I don't know, please leave me alone!
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, new IProperty[]{CHECK_DECAY, DECAYABLE});
    }

    public int getMetaFromState(IBlockState state)
    {
        int i = 0;
//        i = i | ((BlockPlanks.EnumType)state.getValue(VARIANT)).getMetadata(); //Until I return, sweet prince

        if (!((Boolean)state.getValue(DECAYABLE)).booleanValue())
        {
            i |= 4;
        }

        if (((Boolean)state.getValue(CHECK_DECAY)).booleanValue())
        {
            i |= 8;
        }

        return i;
    }

    public IBlockState getStateFromMeta(int meta)
    {
//        return this.getDefaultState().withProperty(VARIANT, this.getWoodType(meta)).withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
        return this.getDefaultState().withProperty(DECAYABLE, Boolean.valueOf((meta & 4) == 0)).withProperty(CHECK_DECAY, Boolean.valueOf((meta & 8) > 0));
    }

    @SideOnly(Side.CLIENT)
    public void initModel(){
        IStateMapper godwhy = (new StateMap.Builder()).ignore(new IProperty[]{CHECK_DECAY, DECAYABLE}).build();
        ModelLoader.setCustomStateMapper(this, godwhy);
    }


//    protected boolean leavesFancy;

//    public TestLeaves(String name, Material material) {
//        super(name, Material.LEAVES, AzMod.creativeTab);
//        this.setTickRandomly(true);
//        this.setHardness(0.2F);
//        this.setLightOpacity(1);
//        this.setSoundType(SoundType.PLANT);
//    }


}
