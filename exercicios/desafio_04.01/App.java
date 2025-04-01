public class App {
   public static void main(String[] args) {
      Banco banco = new Banco();

      System.out.println("Banco" +banco+" aberto!");

      ContaBancaria conta1 = new ContaBancaria(
         "João", 
         1000.0
      );

      System.out.println("Criando conta para João com saldo inicial de 1000.0");
      System.out.println("Quantidade de contas criadas: " + Banco.QuantidadeDeContas());

      ContaBancaria conta2 = new ContaBancaria(
         "Maria", 
         0
      );
      System.out.println("Criando conta para Maria com saldo inicial de 0.0");
      System.out.println("Quantidade de contas criadas: " + Banco.QuantidadeDeContas());

      conta1.ExibirInformacoes();

      conta1.Depositar(500.0);
      conta1.ExibirInformacoes();

      conta1.Sacar(200.0);
      conta1.ExibirInformacoes();

      conta1.Transferir(conta2, 1600.0);
      conta1.ExibirInformacoes();
      conta2.ExibirInformacoes();
   }
   
}
