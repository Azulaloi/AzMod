package az.azmod.item;

import az.azmod.AzMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public class TestItem extends Item {
    public TestItem() {
        setUnlocalizedName(AzMod.MODID + "." + "testitem");
//        setUnlocalizedName("testitem"); //Does NOT do the same thing

//        setRegistryName(AzMod.MODID+":"+"testitem");
        setRegistryName("testitem"); //Seems to do the same thing
        setCreativeTab(AzMod.creativeTab);
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(
                this,
                0,
//                new ModelResourceLocation(getRegistryName().toString())
//                new ModelResourceLocation(getRegistryName().toString(), "inventory")

//                new ModelResourceLocation("azmod:testitem")
//                new ModelResourceLocation("azmod:testitem", "inventory")

                new ModelResourceLocation(getRegistryName(), "inventory")
        );
//        AzMod.logger.log(Level.INFO,this.getRegistryName().toString());
//        AzMod.logger.log(Level.INFO,this.getUnlocalizedName());
    }
}
