package UI;

import Constants.Constants;

import java.awt.*;

public class gameScore extends Rectangle {

    // Instance Variables
    int humanPlayer;
    int aiPlayer;

    public gameScore(int WIDTH, int HEIGHT) {

        WIDTH = Constants.WIDTH; HEIGHT = Constants.HEIGHT;
    }

    public void draw(Graphics g) {

        g.setColor(Color.green);
        g.setFont(new Font("Consolas", Font.BOLD, 60));

        g.drawLine((Constants.WIDTH/2), 0, (Constants.WIDTH/2), Constants.HEIGHT);

        g.drawString(String.valueOf(humanPlayer/10) + String.valueOf(humanPlayer%10), ((Constants.WIDTH/2) - 130), 50);
        g.drawString(String.valueOf(aiPlayer/10) + String.valueOf(aiPlayer%10), ((Constants.WIDTH/2) + 70), 50);
    }
}
