// Benjamin A. Worthington
// September 9th, 2021
// CSCE 3193 Assignment 2 - Creating a mini game with a moving turtle
// View.java

// Import statements
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.JButton;
import java.awt.Color;

class View extends JPanel {

    // Declaring member variables
    JButton b1;
    BufferedImage turtleImage;
    Model model;

    // View constructor
    View(Controller c, Model m) {

        // Set member variable to object reference
        model = m;

        // Tell the controller what view to use
        c.setView(this);

        // Create and add button to view
        b1 = new JButton("Self-Destruct");
        b1.addActionListener(c);
        this.add(b1);


        try {

            // Attempt to load turtle.png
            this.turtleImage = ImageIO.read(new File("turtle.png"));

        } catch(Exception e) {

            // If an error occurs, game exits
            e.printStackTrace(System.err);
            System.exit(1);

        }

    }

    // Draws the turtle on the view
    public void paintComponent(Graphics g) {

        g.setColor(new Color(128, 255, 255));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(this.turtleImage, model.turtleX, model.turtleY, null);

    }

    // Removes button and refreshes screen
    void removeButton() {

        this.remove(b1);
        this.repaint();

    }

}
