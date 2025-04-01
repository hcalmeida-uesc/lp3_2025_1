import javax.swing.JFrame;

public class DesenharSmiley {
   public static void main(String[] args) {

      Smiley painel = new Smiley();
      JFrame janela = new JFrame("Desenhar Smiley");
      janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      janela.setSize(230, 250);
      janela.add(painel);
      janela.setVisible(true);
   }
}
