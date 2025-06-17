import java.util.Scanner;
import java.util.InputMismatchException;

class Divisao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número para dividir 10: ");
        try {
            int denominador = scanner.nextInt();
            int resultado = 10 / denominador;
            System.out.println("O resultado é: " + resultado);
        // Captura uma exceção específica
        } catch (ArithmeticException e) {
            System.out.println("Erro: Não é possível dividir por zero! ");
        // Captura outra exceção específica
        } catch (InputMismatchException e) {
            System.out.println("Erro: Você precisa digitar um número inteiro! 🔢");
        // Captura a classe pai de muitas exceções
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
        finally {
            scanner.close();
            System.out.println("Fim do da operação de divisão! 🎉");
        }
    }
}