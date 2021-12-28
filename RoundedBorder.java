import javax.swing.border.Border;
import java.awt.*;

/**
 * The RoundedBorder class is used to create a rounded border.
 * Class created by user Lalchand on StackOverflow.
 * <a href=
 * "https://stackoverflow.com/questions/1247772/how-to-add-rounded-border-to-jpanel-in-java">Original
 * Post</a>
 * 
 * @author Lalchand
 * @version September 3, 2010
 */
public class RoundedBorder implements Border {
    private int radius;

    /**
     * Constructor for the RoundedBorder class.
     * 
     * @param radius The radius of the border.
     */
    RoundedBorder(int radius) {
        this.radius = radius;
    }

    /**
     * The getBorderInsets method is used to get the insets of the border.
     * 
     * @param c The component that the border is being used on.
     * 
     * @return The insets of the border.
     */
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    /**
     * The isBorderOpaque method is used to determine if the border is opaque.
     * 
     * @return true if the border is opaque.
     */
    public boolean isBorderOpaque() {
        return true;
    }

    /**
     * The paintBorder method is used to paint the border.
     * 
     * @param c The component that the border is being painted on.
     * @param g The graphics object that is used to paint the border.
     * @param x The x coordinate of the border.
     * @param y The y coordinate of the border.
     */
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}