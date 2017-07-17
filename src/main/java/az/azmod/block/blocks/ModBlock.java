package az.azmod.block.blocks;

import az.azmod.AzMod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public abstract class ModBlock extends Block {
    public ModBlock(String name, Material material) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(AzMod.getID(), name);
        setCreativeTab(AzMod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                Item.getItemFromBlock(this),
                0,
                new ModelResourceLocation(getRegistryName(), "inventory"));
    }

//    @Override
//    public abstract boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
//                                             ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ);
//    {return super.onBlockActivated}

//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
//                                             ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
//    {
//        return false;
//    }

//    @Override
//    public boolean onBlockActivated(){
//        super();
//    }

//    @Override
//    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
//                                    ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
//       return super.onBlockActivated(world, pos, state, player, hand, side, hitX, hitY, hitZ);
//    }
}
