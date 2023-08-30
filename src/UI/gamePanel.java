package UI;

import Constants.Constants;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import static Audio.Audio.playSound;

public class gamePanel extends JPanel implements Runnable {

    // Instance Variables
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    gamePaddle humanPaddle;
    gamePaddle aiPaddle;
    gameBall ball;
    gameScore score;

    public gamePanel() {

        newGamePaddle();
        newGameBall();

        score = new gameScore(Constants.WIDTH, Constants.HEIGHT);

        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(Constants.SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    // To reset the game
    public void newGamePaddle() {
        humanPaddle = new gamePaddle(10, (Constants.HEIGHT / 2) - (Constants.PADDLE_HEIGHT / 2), Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, "human");
        aiPaddle = new gamePaddle((Constants.WIDTH - Constants.PADDLE_WIDTH) - 10, (Constants.HEIGHT / 2) - (Constants.PADDLE_HEIGHT / 2), Constants.PADDLE_WIDTH, Constants.PADDLE_HEIGHT, "ai");
        Constants.PADDLE_SPEED = 15;
    }

    // To call a new Ball
    public void newGameBall() {

        random = new Random();
        ball = new gameBall((Constants.WIDTH/2) - (Constants.BALL_DIAMETER/2), random.nextInt((Constants.HEIGHT - Constants.BALL_DIAMETER)), Constants.BALL_DIAMETER, Constants.BALL_DIAMETER);
    }

    // To paint and draw or make the gameFrame attractive
    public void paint(@NotNull Graphics g) {

        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {

        humanPaddle.draw(g);
        aiPaddle.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    // To move "the animation of humanPaddle and gameBall" after each iteration
    public void move() {
        humanPaddle.move();
        aiMove();
        ball.move();
    }

    // make the aiPaddle follow the ball's Y position
    public void aiMove() {

        int ballCenterY = ball.y + Constants.BALL_DIAMETER / 2;
        int aiPaddleCenterY = aiPaddle.y + Constants.PADDLE_HEIGHT/2;

        if (ballCenterY < aiPaddleCenterY) {
            aiPaddle.setYDirection(-Constants.PADDLE_SPEED);
        } else if (ballCenterY > aiPaddleCenterY) {
            aiPaddle.setYDirection(Constants.PADDLE_SPEED);
        } else {
            aiPaddle.setYDirection(0); // Stop if the aiPaddle is aligned with the ball
        }

        aiPaddle.move();
    }

    // If the user wants to choose difficulty
    public void changeSpeed() {

        ball.xVelocity++; // We increase its speed by 1
            if (ball.yVelocity > 0) {
                ball.yVelocity++; // for more difficulty I increased its speed
            } else {
                ball.yVelocity--; // for more difficulty I increased its speed
            }
    }

    // Checking the collision of gameBall with boundaries or paddles
    public void checkCollision() {
        /* Stops paddle at edges */
        // for humanPaddle
        if (humanPaddle.y <= 0) {
            humanPaddle.y = 0;
        }
        if (humanPaddle.y >= (Constants.HEIGHT - Constants.PADDLE_HEIGHT)) {
            humanPaddle.y = (Constants.HEIGHT - Constants.PADDLE_HEIGHT);
        }

        // for aiPaddle
        if (aiPaddle.y <= 0) {
            aiPaddle.y = 0;
        }
        if (aiPaddle.y >= (Constants.HEIGHT - Constants.PADDLE_HEIGHT)) {
            aiPaddle.y = (Constants.HEIGHT - Constants.PADDLE_HEIGHT);
        }

        /* Let's bounce the ball from the top and bottom edges */
        if(ball.y <= 0) {
			ball.setYDirection(-ball.yVelocity);
		}
		if(ball.y >= Constants.HEIGHT - Constants.BALL_DIAMETER) {
			ball.setYDirection(-ball.yVelocity);
		}

        /* Let's bounce the ball from the paddles */

        // for humanPaddle
        if (ball.intersects(humanPaddle)) {

            Constants.PADDLE_SPEED++;

            ball.xVelocity = Math.abs(ball.xVelocity); // changing negative to positive

            if (Constants.CHOOSE.equals("Y") || Constants.CHOOSE.equals("y")) {
                changeSpeed();
            }

            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        // for aiPaddle
        if (ball.intersects(aiPaddle)) {

            ball.xVelocity = Math.abs(ball.xVelocity); // changing negative to positive

            if (Constants.CHOOSE.equals("Y") || Constants.CHOOSE.equals("y")) {
                changeSpeed();
            }

            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }

        /* Gives a point to each and creates new paddles and ball */

        // if the ball touches the left boundary, then AI scores a point
        if (ball.x <= 0) {
            score.aiPlayer++;
            Constants.PADDLE_SPEED = 15;
            playSound("src/Sounds/Score.wav");
            newGameBall();
        }

        // if the ball touches the right boundary, then human player scores a point
        if (ball.x >= (Constants.WIDTH - Constants.BALL_DIAMETER)) {
            score.humanPlayer++;
            Constants.PADDLE_SPEED = 15;
            playSound("src/Sounds/Score.wav");
            newGameBall();
        }

    }

    // To run the game we need a method run
    public void run() {

        // Game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double nanoSeconds = 2094222720 / amountOfTicks;
        double delta = 0.0;

        while (true) {

            long now = System.nanoTime();
            delta += (now - lastTime) / nanoSeconds;
            lastTime = now;

            if (delta >= 1) {
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class ActionListener extends KeyAdapter {

        // When key is pressed like 'W', 'A', 'S' or 'D'
        public void keyPressed(KeyEvent kE) {
            humanPaddle.keyPressed(kE);
        }

        // When key is released like 'W', 'A', 'S' or 'D'
        public void keyReleased(KeyEvent kE) {
            humanPaddle.keyReleased(kE);
        }
    }
}