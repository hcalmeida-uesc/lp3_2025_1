
class Produto{
	public String nome;
	public double preco;
	public int quantidade;
}

class Garrafa{
	private String corPrimaria;
	//private String corSecundaria;
	public int capacidade; //em ml
	private int qtConteudo;
	public String marca;
	public String [] atributos;

	public Garrafa(){
		setCor("sem cor definida");
	}
	public Garrafa(String _cor){
		setCor(_cor);
	}
	public Garrafa(String _cor, int _capacidade){
		setCor(_cor);
		capacidade = _capacidade;
	}

	public String getCor(){
		return corPrimaria;
	}

	public void setCor(String _cor){
		corPrimaria = _cor;
	}

	public String toString(){
		return "Marca: "+marca + "\nCor: "+corPrimaria;
	}

	public void encher(int _quantidade){

		validarQuantidadeConteudo(_quantidade);

		qtConteudo = _quantidade;
	}

	private Boolean validarQuantidadeConteudo(int _quantidade)
	{
		if(_quantidade > capacidade)
		{
			System.out.println("Excedeu a capacidade");
			return false;
		}
		return true;
	}
}

class HelloWorld{
   
   public static void main(String [] args){
	   
      System.out.println("Hello World Java!");
	  
	  Produto produto1 = new Produto();
	  produto1.nome = "Mouse";
	  produto1.preco = 120.00;
	  produto1.quantidade = 2;
	  
	  
	  System.out.println("Produto 1: " + produto1.nome + "\n\tPreço: R$ " + produto1.preco + "\n\tQuantidade: " + produto1.quantidade);

	  Garrafa garrafa1 = new Garrafa();
	  garrafa1.setCor("Preta");
	  //garrafa1.cor = "Preta";
	  garrafa1.capacidade = 1000;
	  garrafa1.marca = "Genérica";

	  garrafa1.encher(1500);

	  System.out.println("A garrafa é da cor "+garrafa1.getCor());
	  
	}
	
}
