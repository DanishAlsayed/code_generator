package main.java;
import java.util.List;
import java.util.ArrayList;
public class Orders {
   private List<String> varNames = new ArrayList<>();
   public int id;
   public String customerName;
   public double price;
   public boolean check;
   public float size;
   public long LONG;
   public short SHORT;
   public byte BYTE;
   public char ascii;
   
   public Orders(int id, String customerName, double price, boolean check, float size, long LONG, short SHORT, byte BYTE, char ascii) {
      this.id = id;
      varNames.add("id");
      this.customerName = customerName;
      varNames.add("customerName");
      this.price = price;
      varNames.add("price");
      this.check = check;
      varNames.add("check");
      this.size = size;
      varNames.add("size");
      this.LONG = LONG;
      varNames.add("LONG");
      this.SHORT = SHORT;
      varNames.add("SHORT");
      this.BYTE = BYTE;
      varNames.add("BYTE");
      this.ascii = ascii;
      varNames.add("ascii");
   }
   public Object f(String var) {
      if (var == null || var.isEmpty()) {
         return null;
      }
      if (varNames.contains(var)) {
         try {
            return Orders.class.getField(var).get(this);
         }
         catch (Exception e) {
            System.out.println("Unable to retrieve variable due to the following error:" + e.getMessage());
            return null;
         }
      }
      return null;
   }
}
