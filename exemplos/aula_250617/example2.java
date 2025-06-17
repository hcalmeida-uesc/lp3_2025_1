import java.util.Scanner;

class RaizQuadradaException extends Exception {
    public RaizQuadradaException() {
        super("Não é possível calcular a raiz quadrada de um número negativo!");
    }
    
}

class Utils{
    public static double raizQuadrada(double numero) throws RaizQuadradaException {
        if (numero < 0) {
            throw new RaizQuadradaException();
        }
        return Math.sqrt(numero);
    }
}

class Example2{
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            double numero = scanner.nextDouble();
            double resultado = Utils.raizQuadrada(numero);
            System.out.println("A raiz quadrada de " + numero + " é: " + resultado);
        } catch (RaizQuadradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            System.out.println("Fim da operação! 🎉");
        }
    }
}