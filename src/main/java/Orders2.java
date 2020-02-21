package main.java;
import java.util.List;
import java.util.ArrayList;
public class Orders2 {
   private List<String> varNames = new ArrayList<>();
   public int id2;
   public String customerName2;
   public double price2;
   public boolean check2;
   public float size2;
   public long LONG2;
   public short SHORT2;
   public byte BYTE2;
   public char ascii2;
   
   public Orders2(int id2, String customerName2, double price2, boolean check2, float size2, long LONG2, short SHORT2, byte BYTE2, char ascii2) {
      this.id2 = id2;
      varNames.add("id2");
      this.customerName2 = customerName2;
      varNames.add("customerName2");
      this.price2 = price2;
      varNames.add("price2");
      this.check2 = check2;
      varNames.add("check2");
      this.size2 = size2;
      varNames.add("size2");
      this.LONG2 = LONG2;
      varNames.add("LONG2");
      this.SHORT2 = SHORT2;
      varNames.add("SHORT2");
      this.BYTE2 = BYTE2;
      varNames.add("BYTE2");
      this.ascii2 = ascii2;
      varNames.add("ascii2");
   }
   public Object f(String var) {
      if (var == null || var.isEmpty()) {
         return null;
      }
      if (varNames.contains(var)) {
         try {
            return Orders2.class.getField(var).get(this);
         }
         catch (Exception e) {
            System.out.println("Unable to retrieve variable due to the following error:" + e.getMessage());
            return null;
         }
      }
      return null;
   }
}
