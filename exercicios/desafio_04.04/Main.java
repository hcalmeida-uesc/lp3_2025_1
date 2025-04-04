public class Main {
   public static void main(String[] args) {
      Data data1 = new Data(15, 8, 2023);
      Data hoje = new Data();
      Data data2 = new Data("29/02/2025");

      System.out.println("Data 1:\t" + data1);
      System.out.println("Hoje:\t" + hoje);
      System.out.println("Data 2:\t" + data2);
   }
   
}
