import java.util.Scanner;

class SenhaInvalidaError extends Exception{
    public SenhaInvalidaError() {
        super("Senha insegura");
    }

}

class Login{
    public static void validarSenha(String senha) throws SenhaInvalidaError {
        if (senha.length() < 8 ) {
            throw new SenhaInvalidaError();
        }
    }
}

class Example3 {
    public static void main(String[] args) {
        System.out.print("Digite uma senha: ");
        Scanner scanner = new Scanner(System.in);
        String senha = scanner.nextLine();
        scanner.close();
        try {
            Login.validarSenha(senha);
            System.out.println("Senha válida");
        } catch (SenhaInvalidaError e) {
            System.out.println(e.getMessage());
        }
    }
}