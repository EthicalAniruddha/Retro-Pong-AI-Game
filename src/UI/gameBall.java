package UI;

import java.awt.*;
import java.util.Random;

public class gameBall extends Rectangle {

    // Instance variables
    Random random;
    int xVelocity; // Velocity on it's x-axis
    int yVelocity; // Velocity on it's y-axis
    int initialSpeed = 2;

    public gameBall(int x, int y, int width, int height) {

        super(x, y, width, height);

        random = new Random();
        int randomXDirection = random.nextInt(2); // if 0 -> left; if 1 -> right

        if (randomXDirection == 0) {
            randomXDirection--;
        }

        setXDirection(randomXDirection * initialSpeed); // increases the xVelocity of the ball by 2

        int randomYDirection = random.nextInt(2); // if 0 -> left; if 1 -> right

        if (randomYDirection == 0) {
            randomYDirection--;
        }

        setYDirection(randomYDirection * initialSpeed); // increases the yVelocity of the ball by 2
    }

    // when the game starts the ball should move in random direction

    // for setting the x-direction of the ball
    public void setXDirection(int randomXDirection) {

        xVelocity = randomXDirection;
    }

    // for setting the y-direction of the ball
    public void setYDirection(int randomYDirection) {

        yVelocity = randomYDirection;
    }

    // to make the ball move
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

    public void draw(Graphics g) {

        g.setColor(Color.white);
        g.fillOval(x, y, height, width); // it should be width then height, but since we want to bounce it from top and bottom edges I have written first height then width
    }

}
