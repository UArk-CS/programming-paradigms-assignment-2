// Benjamin A. Worthington
// September 9th, 2021
// CSCE 3193 Assignment 2 - Creating a mini game with a moving turtle
// Game.java

// Import statements
import javax.swing.JFrame;
import java.awt.Toolkit;

public class Game extends JFrame {

    // Declaring member variables to object references
    Model model;
    View view;
    Controller controller;

    public Game() {

        // Instantiating object references
        model = new Model();
        controller = new Controller(model);
        view = new View(controller, model);

        // Adding event listeners
        view.addMouseListener(controller);
        this.addKeyListener(controller);

        // Setting up Game window
        this.setTitle("Turtle Attack!");
        this.setSize(500, 500);
        this.setFocusable(true);
        this.getContentPane().add(view);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {

        // Instantiating new game object and calling the run method
        Game g = new Game();
        g.run();

    }

    public void run() {

        while(true) {

            // Calling update functions
            controller.update();
            model.update();
            view.repaint(); // Indirect call to view.paintComponent()
            Toolkit.getDefaultToolkit().sync();

            try {

                // Set refresh rate (25 fps)
                Thread.sleep(40);

            } catch(Exception e) {

                // If there is an error, exit game
                e.printStackTrace();
                System.exit(1);

            }

        }

    }

}
