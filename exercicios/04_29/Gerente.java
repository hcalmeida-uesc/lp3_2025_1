
public class Gerente extends Funcionario {
    double bonusGerencial;

    public Gerente(String nome, double salarioBase, double bonusGerencial) {
        super(nome, salarioBase);
        this.bonusGerencial = bonusGerencial;
    }

    public void exibirDados() {
        super.exibirDados(); // Chama o método da classe pai
        System.out.println("Bônus Gerencial: R$" + bonusGerencial);
        System.out.println("Salário Total: R$" + (salarioBase + bonusGerencial));
    }
   
}
