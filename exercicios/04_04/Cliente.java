public class Cliente {
   String nome;
   String cpf;
   Data dataNascimento;

   public Cliente(String nome, String cpf, Data dataNascimento) {
      this.nome = nome;
      this.cpf = cpf;
      this.dataNascimento = dataNascimento;
   }

   public int GetIdade(Data dataAtual) {
      return Data.CalcularIdade(this.dataNascimento, dataAtual);
   }

   public int GetIdade() {
      return Data.CalcularIdade(this.dataNascimento, new Data());
   }
}
