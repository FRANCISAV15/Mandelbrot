import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class FractalPanel extends JPanel implements MouseListener, KeyListener {

    Color[][] pixels;
    int width = 600;
    int height = 400;
    // declare 3 objects
    Palette p;
    View v;
    Complex topLeft;
    Complex botRight;

    public FractalPanel() {
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.BLACK);
        p = new Palette(2);
        v = new View(width, height);
        addMouseListener(this);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Complex point = v.translate(x, y);
                int iterations = Mandelbrot.testPoint(point);
                double normX = 1.0 * iterations / Mandelbrot.threshold;

                g.setColor(p.mapColor(normX));
                g.fillRect(x, y, 1, 1);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        topLeft = v.translate(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        botRight = v.translate(e.getX(), e.getY());
        v.setComplexCorners(topLeft, botRight);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // unused
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == '1') {
            p = new Palette(1);

        }
        if (e.getKeyChar() == '2') {
            p = new Palette(2);

        }
        if (e.getKeyChar() == 'i') {
            if (Mandelbrot.threshold < 10000) {
                Mandelbrot.threshold += 500;
            } else {
                Mandelbrot.threshold = 500;
            }

        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
