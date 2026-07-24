import javax.swing.*;
import java.awt.*;

public class HeadMain {
    public static void main(String[] args) {
        //Create app window
        JFrame frame = new JFrame("Biticut Follies");
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create panel
        JPanel panel = new JPanel(new GridLayout(2,2));
        panel.add(new Head());
        panel.add(new Head());
        panel.add(new Head());
        panel.add(new Head());

        frame.add(panel);
        frame.setVisible(true);
    }
}
