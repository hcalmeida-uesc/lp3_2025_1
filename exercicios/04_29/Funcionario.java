public class Funcionario {
   String nome;
   double salarioBase;

   public Funcionario(String nome, double salarioBase) {
      this.nome = nome;
      this.salarioBase = salarioBase;
   }

   public void exibirDados() {
      System.out.println("Nome: " + nome);
      System.out.println("Salário Base: R$" + salarioBase);
   }
}
