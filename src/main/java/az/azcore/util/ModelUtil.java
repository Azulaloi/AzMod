package az.azcore.util;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.Fluid;

public class ModelUtil {
    public static void registerItemModel(Item item){
        ModelLoader.setCustomModelResourceLocation(
                item,
                0,
                new ModelResourceLocation(item.getRegistryName(), "inventory")
        );
    }

    public static class FluidMappingMischief extends StateMapperBase { //I'm the map, I'm the map
        private ModelResourceLocation location;

        public FluidMappingMischief(Fluid fluid, String ID){
            this.location = new ModelResourceLocation(ID + ":" + fluid.getName());
        }

        @Override
        public ModelResourceLocation getModelResourceLocation(IBlockState something){ return location; }
    }
}
