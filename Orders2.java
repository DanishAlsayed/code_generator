import java.util.List;
class Orders2 {
   private List<String> varNames;
   private int id2;
   private String customerName2;
   private double price2;
   private boolean check2;
   private float size2;
   private long LONG2;
   private short SHORT2;
   private byte BYTE2;
   private char ascii2;
   
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
