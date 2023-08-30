package UI;

import Constants.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;

public class gamePaddle extends Rectangle {

    // Instance variables
    String id; // ids for humanPaddle and aiPaddle
    int yVelocity; // to check the velocity of paddles moving up or down

    public gamePaddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, String id) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.id = id;
    }

    // for setting the y-direction of the paddles
    public void setYDirection(int yDirection) {

        yVelocity = yDirection;
    }

    // for moving the paddles
    public void move() {

        y += yVelocity;
    }

    public void draw(Graphics g) {

        if (id.equals("human")) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }

        g.fillRect(x, y, width, height);
    }

    public void keyPressed(KeyEvent kE) {

        if (kE.getKeyCode() == KeyEvent.VK_UP || kE.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(-Constants.PADDLE_SPEED);
            move();
        }

        if (kE.getKeyCode() == KeyEvent.VK_DOWN || kE.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(Constants.PADDLE_SPEED);
            move();
        }
    }

    public void keyReleased(KeyEvent kE) {

        if (kE.getKeyCode() == KeyEvent.VK_UP || kE.getKeyCode() == KeyEvent.VK_W) {
            setYDirection(0);
        }
        if (kE.getKeyCode() == KeyEvent.VK_DOWN || kE.getKeyCode() == KeyEvent.VK_S) {
            setYDirection(0);
        }
    }

    // Add AI controller logic here
    public void aiMove(int ballY) {
        // Implement your AI logic here
        // For example, you can make the AI follow the ball's Y position
        // You may want to adjust this logic based on your game's requirements
        if (y < ballY) {
            setYDirection(Constants.PADDLE_SPEED);
        } else if (y > ballY) {
            setYDirection(-Constants.PADDLE_SPEED);
        } else {
            setYDirection(0); // Stop if the AI paddle is aligned with the ball
        }
        move();
    }
}
