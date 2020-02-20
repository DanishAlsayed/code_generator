import java.util.List;
class Orders {
   private List<String> varNames;
   private int id;
   private String customerName;
   private double price;
   private boolean check;
   private float size;
   private long LONG;
   private short SHORT;
   private byte BYTE;
   private char ascii;
   
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
   public int f(final String var) {
      if (var == null || var.isEmpty()) {
         return 0;
      }
      if (varNames.contains(var)) {
         return 1;
      }
      return 0;
   }
}
