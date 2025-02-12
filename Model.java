/*
 * Author: Diego Ruiz
 * Date: 2/3/2025
 * Assignment: Turtle Wars - Java GUI Game
 * Description: This program creates a simple interactive game where a turtle moves
 *              based on user inputs (mouse clicks and keyboard controls).
 */

public class Model {
    private int turtleX;
    private int turtleY;
    private int destX;
    private int destY;
    public int turtleSpeed;

    public Model() {
    turtleSpeed = 4; // Increase speed 4x
}

    public void update() {
    // Move right or left while preventing overshooting
    if (Math.abs(this.turtleX - this.destX) > turtleSpeed) {
        this.turtleX += Math.min(turtleSpeed, Math.abs(destX - turtleX)) * (this.turtleX < this.destX ? 1 : -1);
    } else {
        this.turtleX = this.destX;
    }

    // Move up or down while preventing overshooting
    if (Math.abs(this.turtleY - this.destY) > turtleSpeed) {
        this.turtleY += Math.min(turtleSpeed, Math.abs(destY - turtleY)) * (this.turtleY < this.destY ? 1 : -1);
    } else {
        this.turtleY = this.destY;
    }
}


    public void setDestination(int x, int y) {
        this.destX = x;
        this.destY = y;
    }

    public int getTurtleX() { return turtleX; }
    public int getTurtleY() { return turtleY; }

    public void moveRight() { this.destX += turtleSpeed; }
public void moveLeft() { this.destX -= turtleSpeed; }
public void moveDown() { this.destY += turtleSpeed; }
public void moveUp() { this.destY -= turtleSpeed; }

}
