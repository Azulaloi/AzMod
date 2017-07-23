package az.azcore.block;

import az.azcore.registry.IRegisterable;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

import static az.azcore.util.AzUtil.unlocalizedWithID;

public abstract class BaseBlock extends Block implements IRegisterable {
    private String ID = Loader.instance().activeModContainer().getModId().toLowerCase();

    public BaseBlock(String name, Material material){
        super(material);
        setUnlocalizedName(unlocalizedWithID(name, ID));
        setRegistryName(ID, name);
    }

    @Override
    public void register() {
        ForgeRegistries.BLOCKS.register(this);
    }
}
