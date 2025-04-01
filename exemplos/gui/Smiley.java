import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel  ;

public class Smiley extends JPanel{
   public void paintComponent(Graphics g) {
      super.paintComponent(g);

      g.setColor(Color.YELLOW);
      g.fillOval(10, 10, 200, 200); // Cabeça

      g.setColor(Color.BLACK);
      g.fillOval(55, 65, 30,  30); // Olho esquerdo
      g.fillOval(135, 65, 30, 30); // Olho direito

      g.fillOval(50, 110, 120, 60); // Boca

      g.setColor(Color.YELLOW);
      g.fillRect(50, 110, 120, 30); // Boca sorrindo
      g.fillOval(50, 120, 120, 40); // Boca sorrindo

   }
}
