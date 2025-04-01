class Banco {
   public static void main(String[] args) {
      System.out.println("Banco aberto!");
      ContaBancaria conta1 = new ContaBancaria(
         "João", 
         1000.0
      );

      ContaBancaria conta2 = new ContaBancaria(
         "Maria", 
         0
      );

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
