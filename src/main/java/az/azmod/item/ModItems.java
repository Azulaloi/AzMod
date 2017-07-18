package az.azmod.item;

import az.azcore.registry.IRegisterable;

import java.util.ArrayList;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public class ModItems {
//    @GameRegistry.ObjectHolder("azmod:testitem")
//    public static TestItem testItem;
//
//    @SideOnly(Side.CLIENT) //Client-side conditional
//    public static void initModels(){
//        testItem.initModel();
//    }

   public static void preInit(){
      testItem = new TestItem("testitem");
      testItem2 = new TestItem("testitem2");

      registerables.add(testItem);
      registerables.add(testItem2);

      for (IRegisterable registerable : registerables) {
         registerable.register();
      }
   }

   private static ArrayList<IRegisterable> registerables = new ArrayList<>();

   public static TestItem testItem;
   public static TestItem testItem2;
}
