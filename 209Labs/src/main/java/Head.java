import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class Head extends JPanel {
    private boolean mouseInside;

    public  Head() {
        mouseInside = false;

        setPreferredSize(new Dimension(500, 500));
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        this.addMouseListener(new MyMouseListener() {});
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            mouseInside = true;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            mouseInside = false;
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Erase previous contents.
        // Downcast to Graphics2D for access to the modern Java 2D API.
        var g2 = (Graphics2D) g;
        g2.setPaint(Color.BLACK);

        drawHead(g2);
        drawMouth(g2);

        if(mouseInside) {
            g2.drawOval(150, 175, 50, 50);
            g2.drawOval(300, 175, 50, 50);
        }
        else{
            g2.drawLine(150,200, 200, 200);
            g2.drawLine(300, 200, 350, 200);
        }
    }

    private void drawMouth(Graphics2D g2) {
        g2.drawRect(200, 300,100, 40);
    }

    private void drawHead(Graphics2D g2) {
        int x = 100;
        int y = 100;
        int diameter = 300;

        g2.drawOval(x, y, diameter, diameter);
    }


}
