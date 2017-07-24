package az.azmod.item.armor;

import az.azcore.util.AzUtil;
import az.azmod.AzMod;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

/**
 * Created by Azulaloi on 7/24/2017
 */
public class TestArmor extends ItemArmor {

    public TestArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name){
        super(material, 0, slot);
        setUnlocalizedName(AzUtil.unlocalizedWithID(name, AzMod.MODID));
        setRegistryName(name);
        setCreativeTab(AzMod.creativeTab);
    }
}
