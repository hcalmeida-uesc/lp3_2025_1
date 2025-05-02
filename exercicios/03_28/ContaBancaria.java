public class ContaBancaria {
   private String titular;
   private double saldo;

   public String getTitular() {
      return this.titular;
   }

   public double getSaldo() {
      return this.saldo;
   }


   public ContaBancaria(String titular, double saldo) {
      this.titular = titular;
      this.saldo = saldo;
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
      }
   }
   public void Sacar(double valor){
      if(valor <= 0){
         System.out.println("Valor inválido");
      }else{
         this.saldo -= valor;
      }
   }

   public void Transferir(ContaBancaria contaDestino, double valor){
      this.Sacar(valor);
      contaDestino.Depositar(valor);
   }
}
