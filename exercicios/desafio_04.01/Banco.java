class Banco {
   // Modificar as classes Banco e ContaBancaria para conseguir contabilizar a quantidade de contas bancárias criadas por banco

   private static final String NOME_BANCO = "Banco do Brasil";
   
   public static int QuantidadeDeContas(){
      return ContaBancaria.QuantidadeDeContas();
   }
 
   public String toString(){
      return NOME_BANCO;
   }

   
}
