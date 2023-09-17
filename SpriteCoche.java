import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SpriteCoche extends JLabel{
    
    public SpriteCoche(int x, int y) {
        ImageIcon imageIcon = new ImageIcon("coche.png");
        Image image = imageIcon.getImage();
        Image imageScaled = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(imageScaled);
        this.setBounds(x, y, 100, 100);
        this.setIcon(imageIcon);
    }
}
