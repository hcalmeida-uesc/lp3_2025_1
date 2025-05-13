package exemplos.aula_250513.autenticacao;

import java.util.List;

interface Autenticavel {
    public boolean autenticar(String senha);
}

interface CRAA{
    public double calcularCRAA();
}

abstract class Usuario {
    protected String nome;
}

class Professor extends Usuario implements Autenticavel {
    private String senha;

    public Professor(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

class Aluno extends Usuario implements CRAA, Autenticavel {
    public String matricula;
    private String senha;

    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }

    @Override
    public double calcularCRAA() {
        // Implementação do cálculo do CRAA
        return 0.0; // Exemplo de retorno
    }

    @Override
    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }
}

class App {
    public static void main(String[] args) {
        Professor helder = new Professor("Hélder", "senha123");
        Aluno caua = new Aluno("Cauã", "123456");

        
        if (helder.autenticar("senha123")) {
            System.out.println("Professor autenticado com sucesso!");
        } else {
            System.out.println("Falha na autenticação do professor.");
        }

        System.out.println("Aluno + " + caua.nome + " matricula: " + caua.matricula); 

        CRAA jessica = new Aluno("Jéssica", "2023002");

        List<Autenticavel> lista = List.of(helder, caua);
    }
}