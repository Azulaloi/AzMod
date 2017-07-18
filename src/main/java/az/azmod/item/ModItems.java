package az.azmod.item;

import az.azcore.registry.IRegisterable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Azulaloi on 7/14/2017.
 */
public class ModItems {

   public static void preInit(){
      testItem = new TestItem("testitem");
      testItem2 = new TestItem("testitem2");

      registerables.add(testItem);
      registerables.add(testItem2);


      for (IRegisterable registerable : registerables) {
         registerable.register();
      }

//      ModelStorage.modelList.add(testItem);
//      ModelStorage.modelList.add(testItem2);

   }

   private static ArrayList<IRegisterable> registerables = new ArrayList<>();

   @SideOnly(Side.CLIENT) //Client-side conditional
   public static void initModels(){
      for(IRegisterable registerable : registerables){
         registerable.initModel();
      }
//        testItem.initModel();
   }

   public static TestItem testItem;
   public static TestItem testItem2;
}
