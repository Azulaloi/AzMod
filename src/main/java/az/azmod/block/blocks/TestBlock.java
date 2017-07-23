package az.azmod.block.blocks;

import az.azcore.block.ModBlock;
import az.azmod.AzMod;
import net.minecraft.block.material.Material;

/**
 * Created by Azulaloi on 7/10/2017.
 */
public class TestBlock extends ModBlock {
    public TestBlock(String name, Material material) {
        super(name, material, AzMod.creativeTab);
    }
}
