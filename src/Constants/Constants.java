/** Here the variables are Constants */

package Constants;

import java.awt.*;

public class Constants {

    // For Screen
    public static final short HEIGHT = 795;
    public static final short WIDTH = 1365;

    public static final String TITLE = "Retro Pong Game";

    public static final Dimension SCREEN_SIZE = new Dimension(WIDTH, HEIGHT);

    // For game ball
    public static final int BALL_DIAMETER = 20;

    // For game paddle
    public static final int PADDLE_HEIGHT = 150;
    public static final int PADDLE_WIDTH = 15;

    public static int PADDLE_SPEED = 15;

    // For reducing or increasing game difficulty
    public static String CHOOSE = "";

    // For having a background sound or not
    public static String SOUND = "";

    // For Loading Screen
    public static final short LOAD_SCREEN_HEIGHT = 500;
    public static final short LOAD_SCREEN_WIDTH = 500;
    public static final Dimension LOAD_SCREEN_SIZE = new Dimension(LOAD_SCREEN_WIDTH, LOAD_SCREEN_HEIGHT);
    public static final byte BAR_HEIGHT = 50;

    // To break the game
    public static boolean BREAK = false;
}