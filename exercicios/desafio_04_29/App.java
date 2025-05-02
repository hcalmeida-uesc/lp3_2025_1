public class App {
   public static void main(String[] args) {
      Funcionario funcionario = new Funcionario("João", 3000.00);
      funcionario.exibirDados();

      System.out.println("-------------------------");

      Gerente gerente = new Gerente("Maria", 5000.00, 1000.00);
      gerente.exibirDados();
   }
}
