import java.util.Calendar;
public class Data {
   int dia;
   int mes;
   int ano;

   public Data() {
      Calendar hoje = java.util.Calendar.getInstance();
      setData( hoje.get(Calendar.DAY_OF_MONTH),
               hoje.get(Calendar.MONTH)+1,
               hoje.get(Calendar.YEAR)
      );
      ValidarData();
   }

   public Data(int dia, int mes, int ano) {
      setData(dia, mes, ano);
      ValidarData();
   }

   public Data(String data) {
      String[] partes = data.split("/");
      setData( Integer.parseInt(partes[0]),
               Integer.parseInt(partes[1]),
               Integer.parseInt(partes[2]));
      ValidarData();
   }

   private void setData(int dia, int mes, int ano) {
      this.dia = dia;
      this.mes = mes;
      this.ano = ano;
   }

   private void ValidarData(){
      if (!DataValida(this)) {
         System.out.println("Data inválida (" + this + ")");
         setData(1, 1, 1900);
      }
   }

   private Boolean DataValida(Data data){
      if (data.ano < 1 || data.mes < 1 || data.mes > 12 || data.dia < 1) {
         return false;
      }

      int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

      // Verifica se é ano bissexto
      if ((data.ano % 4 == 0 && data.ano % 100 != 0) || (data.ano % 400 == 0)) {
         diasPorMes[1] = 29; // Fevereiro tem 29 dias em anos bissextos
      }

      if (data.dia > diasPorMes[data.mes - 1]) {
         return false;
      }
      return true;
   }

   public static Boolean IsEqual(Data data1, Data data2){
      return (data1.dia == data2.dia && data1.mes == data2.mes && data1.ano == data2.ano);
   }

   public String toString(){
      return this.dia + "/" + this.mes + "/" + this.ano;
   }
}
