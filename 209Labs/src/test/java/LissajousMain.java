import javax.swing.*;

public class LissajousMain {
    public static void main(String[] args) {
        //Create app window
        JFrame frame = new JFrame("Lissajous demo");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel
        JPanel panel = new Lissajous(600);
        frame.add(panel);

        frame.setVisible(true);
    }
}
