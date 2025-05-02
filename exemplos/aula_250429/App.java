class Animal {
    protected String nome;
    
    public Animal(String nome) {
        this.nome = nome;
    }
   public void comer() {
       System.out.println(this.nome + " está comendo");
   }
}


class Cachorro extends Animal {
    protected String nome;
    public Cachorro(String nome) {
         super(nome); // Chama o construtor da classe pai
    }
   public void latir() {
       System.out.println(super.nome + " está latindo");
   }
}

class Gato extends Animal {
    protected String nome;
    public Gato(String nome) {
         super(nome); // Chama o construtor da classe pai
    }
   public void miar() {
       System.out.println(this.nome + " está miando");
   }
}

// em python, o princípio do MRO diz
// Viralata -> Cachorro -> Animal -> Gato
// class Viralata extends Cachorro, Gato {
//     public Viralata(String nome) {
//          super(nome); // Chama o construtor da classe pai
//     }
//    public void correr() {
//        System.out.println(this.nome + " está correndo");
//    }
// }

public class App {
   public static void main(String[] args) {
        Cachorro dog = new Cachorro("Billy");
        dog.comer();  // método herdado
        dog.latir();  // método da subclasse

        Gato cat = new Gato("Tofu");
        cat.comer();  // método herdado
        cat.miar();  // método da subclasse
   }
}
