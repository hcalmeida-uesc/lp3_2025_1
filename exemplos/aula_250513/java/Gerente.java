package exemplos.aula_250513.java;

public class Gerente extends Funcionario {
    public double bonus;
    
    @Override
    public double calcularSalario() {
        return this.salario + this.bonus;
    }


}
