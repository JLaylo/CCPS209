import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

public class Lissajous extends JPanel {
    private int a;
    private int b;
    private double delta;
    private int size;

    public Lissajous(int size) {
        a = 6;
        b = 5;
        delta = 0.5;

        this.size = size;
        this.setPreferredSize(new Dimension(size, size));

        JLabel aLabel = new JLabel("a");
        JLabel bLabel = new JLabel("b");
        JLabel deltaLabel = new JLabel("delta");

        JTextField aField = new JTextField(String.valueOf(a), 5);
        JTextField bField = new JTextField(String.valueOf(b), 5);
        JTextField deltaField = new JTextField(String.valueOf(delta), 5);

        ActionListener TextFieldListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                a = Integer.parseInt(aField.getText());
                b = Integer.parseInt(bField.getText());
                delta = Double.parseDouble(deltaField.getText());
                repaint();
            }
        };

        aField.addActionListener(TextFieldListener);
        bField.addActionListener(TextFieldListener);
        deltaField.addActionListener(TextFieldListener);

        this.add(aLabel);
        this.add(aField);
        this.add(bLabel);
        this.add(bField);
        this.add(deltaLabel);
        this.add(deltaField);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2 = (Graphics2D) g;
        double x = size/2 + 2*size/5 * Math.sin(delta);;
        double y = size/2 + 2*size/5 * Math.sin(0);;
        double newX;
        double newY;

        for (double t = 0 ; t < (a/getGCD(a,b))*b ; t += 0.01) {
            newX = size/2 + 2*size/5 * Math.sin(a*t*Math.PI + delta);
            newY = size/2 + 2*size/5 * Math.sin(b*t*Math.PI);

            g2.setStroke(new BasicStroke(4.0f));

            Line2D.Double line = new Line2D.Double(x, y, newX, newY);
            g2.draw(line);

            x = newX;
            y = newY;
        }
    }

    public static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
