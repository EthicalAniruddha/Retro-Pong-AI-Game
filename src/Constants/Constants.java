/** Here the variables are Constants */

package Constants;

import java.awt.*;

public class Constants {

<<<<<<< HEAD
    public static final int HEIGHT = 600;
    public static final int WIDTH = 1020;
=======
    // For Screen
    public static final short HEIGHT = 795;
    public static final short WIDTH = 1365;
>>>>>>> a7b1c57 (Retro-Pong-AI-Game)

    public static final String TITLE = "Retro Pong Game";

    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);

<<<<<<< HEAD
    public static final int BALL_DIAMETER = 20;

    public static final int PADDLE_HEIGHT = 100;
    public static final int PADDLE_WIDTH = 25;

    public static final int PADDLE_SPEED = 10;
=======
    // For reducing or increasing game difficulty
    public static String CHOOSE = "";

    // For having a background sound or not
    public static String SOUND = "";

    // For gameBall
    public static final byte BALL_DIAMETER = 30;

    // For gamePaddle
    public static final short PADDLE_HEIGHT = 160;
    public static final byte PADDLE_WIDTH = 20;

    public static short PADDLE_SPEED = 15;

    // For Loading Screen
    public static final short LOAD_SCREEN_HEIGHT = 500;
    public static final short LOAD_SCREEN_WIDTH = 500;
    public static final Dimension LOAD_SCREEN_SIZE = new Dimension(LOAD_SCREEN_WIDTH, LOAD_SCREEN_HEIGHT);
    public static final byte BAR_HEIGHT = 50;
>>>>>>> a7b1c57 (Retro-Pong-AI-Game)
}
