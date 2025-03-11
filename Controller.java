
/*
 * Author: Diego Ruiz
 * Date: 2/3/2025
 * Assignment: Turtle Wars - Java GUI Game
 * Description: This program creates a simple interactive game where a turtle moves
 *              based on user inputs (mouse clicks and keyboard controls).
 */
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements ActionListener, MouseListener, KeyListener {
    private Model model;
    private View view;

    private boolean keyLeft;
    private boolean keyRight;
    private boolean keyUp;
    private boolean keyDown;

    public Controller(Model m) {
        this.model = m;
        this.view = null;
    }

    public void setView(View v) {
        this.view = v;

        v.addMouseListener(this);
        v.getButton().addActionListener(this);
    }

    // Handles button click event (removes button)
    @Override
    public void actionPerformed(ActionEvent e) {
        view.removeButton();
    }

    // Handles mouse click (sets turtle destination)
    @Override
    public void mousePressed(MouseEvent e) {
        model.setDestination(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    // Handles key press events
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = true;
                break;
            case KeyEvent.VK_LEFT:
                keyLeft = true;
                break;
            case KeyEvent.VK_UP:
                keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = true;
                break;
        }
    }

    // Handles key release events
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                keyRight = false;
                break;
            case KeyEvent.VK_LEFT:
                keyLeft = false;
                break;
            case KeyEvent.VK_UP:
                keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
                keyDown = false;
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }

        // Allow 'q' to exit the game
        char c = Character.toLowerCase(e.getKeyChar());
        if (c == 'q') {
            System.exit(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Handles turtle movement based on key states
    public void update() {
        if (keyRight)
            model.moveRight();
        if (keyLeft)
            model.moveLeft();
        if (keyDown)
            model.moveDown();
        if (keyUp)
            model.moveUp();
    }
}
