// Benjamin A. Worthington
// September 9th, 2021
// CSCE 3193 Assignment 2 - Creating a mini game with a moving turtle
// Model.java

public class Model {

    // Declaring member variables
    int turtleX;
    int turtleY;
    int destX;
    int destY;

    // Default constructor
    Model() {}

    // Update method to redraw the turtle
    public void update() {

        // Move the turtle in the -x and +x direction
        if(this.turtleX < this.destX) {

            this.turtleX += Math.min(4, destX - turtleX);

        } else if(this.turtleX > this.destX) {

            this.turtleX -= Math.min(4, turtleX - destX);

        }

        // Move the turtle in the -y and +y direction
        if(this.turtleY < this.destY) {

            this.turtleY += Math.min(4, destY - turtleY);

        } else if(this.turtleY > this.destY) {

            this.turtleY -= Math.min(4, turtleY - destY);

        }

    }

    // Setter method for destX and destY
    public void setDestination(int x, int y) {

        this.destX = x;
        this.destY = y;

    }

}
