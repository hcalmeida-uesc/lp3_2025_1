package exemplos.aula_250513.java;

public abstract class Funcionario {
    protected double salario;
    protected String nome;

    public void iniciarDia(){
        System.out.println("Iniciando o dia de trabalho");
    }
    public void terminarDia(){
        System.out.println("Terminando o dia de trabalho");
    }
    
    public abstract double calcularSalario(); // Método abstrato, não tem implementação
}
