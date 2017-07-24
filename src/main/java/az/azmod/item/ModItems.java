package az.azmod.item;

import az.azcore.registry.IRegisterable;
import az.azmod.item.items.TestFood;
import az.azmod.item.items.TestItem;
import az.azmod.item.tools.*;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public class ModItems {

   private static ArrayList<IRegisterable> registerables = new ArrayList<>();

//   public static TestItem testItem = new TestItem("testitem");

   public static void preInit(){
      testItem = new TestItem("testitem");
      testItem2 = new TestItem("testitem2");
      testFood = new TestFood();

      testSword = new TestSword();
      testAxe = new TestAxe();
      testHoe = new TestHoe();
      testPickaxe = new TestPickaxe();
      testShovel = new TestShovel();

      registerables.add(testItem);
      registerables.add(testItem2);

      registerables.add(testFood);
      registerables.add(testSword);
      registerables.add(testShovel);
      registerables.add(testPickaxe);
      registerables.add(testHoe);
      registerables.add(testAxe);

      for (IRegisterable registerable : registerables) {
         registerable.register();
      }
   }



   @SideOnly(Side.CLIENT) //Client-side conditional
   public static void initModels(){
      for(IRegisterable registerable : registerables){
         registerable.initModel();
      }
   }

   public static TestItem testItem;
   public static TestItem testItem2;
   public static TestFood testFood;

   public static TestSword testSword;
   public static TestPickaxe testPickaxe;
   public static TestAxe testAxe;
   public static TestShovel testShovel;
   public static TestHoe testHoe;

}
