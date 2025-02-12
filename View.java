/*
 * Author: Diego Ruiz
 * Date: 2/3/2025
 * Assignment: Turtle Wars - Java GUI Game
 * Description: This program creates a simple interactive game where a turtle moves
 *              based on user inputs (mouse clicks and keyboard controls).
 */

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;

public class View extends JPanel {
    private JButton b1;
    private Controller controller;
    private Model model;
    private BufferedImage turtle_image;

    public View(Controller c, Model m) {
        this.controller = c;
        this.model = m;
        c.setView(this);

        this.addMouseListener(controller); // Attach MouseListener to JPanel

        b1 = new JButton("Don't push me!");
        b1.addActionListener(c);
        this.add(b1);

        try {
            this.turtle_image = ImageIO.read(new File("images/turtle.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    void removeButton() {
        this.remove(b1);
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(128, 255, 255)); // Cyan background
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // Draw turtle at position stored in Model
        if (turtle_image != null) {
            g.drawImage(turtle_image, model.getTurtleX(), model.getTurtleY(), null);
        }
    }
}
