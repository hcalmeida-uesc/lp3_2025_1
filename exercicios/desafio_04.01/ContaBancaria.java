public class ContaBancaria {
   private String titular;
   private double saldo;
   private static int quantidadeContas = 0;

   public String getTitular() {
      return this.titular;
      }

      public double getSaldo() {
      return this.saldo;
   }

   // Constructor
   public ContaBancaria(String titular, double saldo) {
      this.titular = titular;
      this.saldo = saldo;
      IncrementaContas();
   }
   private static void IncrementaContas(){
      quantidadeContas++;
   }

   public static int QuantidadeDeContas() {
      return quantidadeContas;
   }

   public void ExibirInformacoes(){
      System.out.println("Titular: " + this.titular);
      System.out.println("Saldo: " + this.saldo);
   }
   public void Depositar(double valor){
      if(valor <= 0){
         System.out.println("Valor inválido");
      }else{
         this.saldo += valor;
         System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
      }
   }
   public void Sacar(double valor){
      if(valor <= 0){
         System.out.println("Valor inválido");
      }else{
         this.saldo -= valor;
         System.out.println("Saque de R$" + valor + " realizado com sucesso.");
      }
   }

   public void Transferir(ContaBancaria contaDestino, double valor){
      this.Sacar(valor);
      contaDestino.Depositar(valor);
      System.out.println("Transferência de R$" + valor + " para " + contaDestino.getTitular() + " realizada com sucesso.");
   }
}
