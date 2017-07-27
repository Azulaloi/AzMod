package az.azmod.block.blocks;

import az.azmod.AzMod;
import az.azmod.util.Tree;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

import static az.azcore.util.AzUtil.unlocalizedWithID;

/**
 * Created by Azulaloi on 7/27/2017
 */
public class TestSapling extends BlockBush implements IGrowable {

    public TestSapling(String name, Material material, CreativeTabs creativeTab){
        super(material);
        setUnlocalizedName(unlocalizedWithID(name, AzMod.MODID));
        setRegistryName(name);
        setCreativeTab(creativeTab);
    }

    //Grows when exposed to light
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
            {
                this.grow(worldIn, pos, state, rand);
            }
        }
    }

    @Override
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return (double)worldIn.rand.nextFloat() < 0.45D;
    }

    @Override
    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        this.grow(worldIn, pos, state, rand);
    }

    private void grow(World worldIn, BlockPos pos, IBlockState state, Random rand) {
            this.generateTree(worldIn, pos, state, rand);
    }

    private void generateTree(World worldIn, BlockPos pos, IBlockState state, Random rand){
        worldIn.setBlockToAir(pos);
        new Tree(true, true).generate(worldIn, rand, pos);
    }
}
