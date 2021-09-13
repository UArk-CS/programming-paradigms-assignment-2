// Benjamin A. Worthington
// September 9th, 2021
// CSCE 3193 Assignment 2 - Creating a mini-game with a moving turtle
// Controller.java

// Import statements
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

class Controller implements ActionListener, MouseListener, KeyListener {

    // Declaring member variables for object references
    View view;
    Model model;

    // Declaring member variables for arrow keys
    boolean keyLeft;
    boolean keyRight;
    boolean keyUp;
    boolean keyDown;

    // Controller constructor
    Controller(Model m) {

        model = m;

    }

    // Setter method for view
    void setView(View v) {

        view = v;

    }

    // Update method to increment destX and destY to correct values if arrow key is being pressed
    void update() {

        if(keyRight) {

            model.destX += 4;

        }

        if(keyLeft) {

            model.destX -= 4;

        }

        if(keyUp) {

            model.destY -= 4;

        }

        if(keyDown) {

            model.destY += 4;

        }

    }

    public void actionPerformed(ActionEvent e) {

        view.removeButton();

    }

    // Mouse Event methods
    // When the mouse is clicked, destX and destY are set to the coordinates of the pointer
    public void mousePressed(MouseEvent e) {

        model.setDestination(e.getX(), e.getY());

    }

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseClicked(MouseEvent e) {}

    // Key Event methods
    // When an arrow key is pressed, change corresponding member variable to true
    public void keyPressed(KeyEvent e) {

        switch(e.getKeyCode()) {

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

    // When an arrow key is released, change corresponding member variable to false
    public void keyReleased(KeyEvent e) {

        switch(e.getKeyCode()) {

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

        }

    }

    public void keyTyped(KeyEvent e) {}

}
