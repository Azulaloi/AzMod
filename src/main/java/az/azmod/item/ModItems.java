package az.azmod.item;

import az.azcore.util.ModelUtil;
import az.azmod.AzMod;
import az.azmod.item.items.TestFood;
import az.azmod.item.items.TestItem;
import az.azmod.item.tools.*;
import az.azmod.proxy.ClientProxy;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Azulaloi on 7/14/2017.
 */
@Mod.EventBusSubscriber(modid = AzMod.MODID)
public class ModItems {

   public static TestItem testItem = new TestItem("testitem");
   public static TestItem testItem2 = new TestItem("testitem2");

   public static TestFood testFood = new TestFood();

   public static TestSword testSword = new TestSword();
   public static TestShovel testShovel = new TestShovel();
   public static TestPickaxe testPickaxe = new TestPickaxe();
   public static TestAxe testAxe = new TestAxe();
   public static TestHoe testHoe = new TestHoe();

   @SubscribeEvent
   public static void registerItems(RegistryEvent.Register<Item> event){
      event.getRegistry().registerAll(
              testItem,
              testItem2,

              testFood,

              //Tools
              testSword,
              testShovel,
              testPickaxe,
              testAxe,
              testHoe
      );

//      ModelLoader.setCustomModelResourceLocation(
//              testItem,
//              0,
//              new ModelResourceLocation("azmod:testitem", "inventory")
//      );

      if (AzMod.proxy instanceof ClientProxy){
         ModelUtil.registerItemModel(testItem);
         ModelUtil.registerItemModel(testItem2);

         ModelUtil.registerItemModel(testFood);

         ModelUtil.registerItemModel(testSword);
         ModelUtil.registerItemModel(testShovel);
         ModelUtil.registerItemModel(testPickaxe);
         ModelUtil.registerItemModel(testAxe);
         ModelUtil.registerItemModel(testHoe);
      }

   }

//   @SideOnly(Side.CLIENT) //Client-side conditional
//   public static void initModels(){
//      for(IRegisterable registerable : registerables){
//         registerable.initModel();
//      }
//   }
}
