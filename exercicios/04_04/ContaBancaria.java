public class ContaBancaria {
   private String titular;
   private Cliente cliente;
   private double saldo;
   private static int quantidadeContas = 0;
   private Data dataAbertura;

   public String getTitular() {
      return this.cliente.nome;
   }

   public double getSaldo() {
      return this.saldo;
   }

   public ContaBancaria(Cliente cliente, double saldo, Data dataAbertura) {
      this.cliente = cliente;
      this.saldo = saldo;
      this.dataAbertura = dataAbertura;
      IncrementaContas();
   }

   // Constructor
   public ContaBancaria(String titular, double saldo) {
      this(titular, saldo, new Data());
   }

   // Constructor
   public ContaBancaria(String titular, double saldo, Data dataAbertura) {
      this(new Cliente(titular, "", new Data()), saldo, dataAbertura);
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
      System.out.println("Data de Abertura: " + this.dataAbertura);
   }
   public void Depositar(double valor, Data dataDeposito){
      if(valor <= 0){
         System.out.println("Valor inválido");
      }else{
         this.saldo += valor;
         System.out.println("Data do depósito: " + dataDeposito);
         System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
      }
   }
   public void Depositar(double valor){
      this.Depositar(valor, new Data());
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
