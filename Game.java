/*
 * Author: Diego Ruiz
 * Date: 2/3/2025
 * Assignment: Turtle Wars - Java GUI Game
 * Description: This program creates a simple interactive game where a turtle moves
 *              based on user inputs (mouse clicks and keyboard controls).
 */
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame {
    private Model model;
    private View view;
    private Controller controller;

    public Game() {
    model = new Model(); // Create Model instance
    controller = new Controller(model); // Pass Model to Controller
    view = new View(controller, model); // Pass Model to View

    this.setTitle("Turtle Wars!"); // Change window title
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(800, 600);
    this.add(view);
    this.setVisible(true);

    this.addKeyListener(controller); // Attach KeyListener
    this.setFocusable(true); // Ensure focus on the window
    this.requestFocus();
}


    public void run() {
        while (true) {
            controller.update(); // Ensuring controller updates correctly
            model.update(); // Update turtle position
            view.repaint(); // Redraw screen
            Toolkit.getDefaultToolkit().sync(); // Ensure smooth animation

            // Sleep for 50ms
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.run(); // Start the game loop
    }
}
