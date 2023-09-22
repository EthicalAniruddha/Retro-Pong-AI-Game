package UI;

import Constants.Constants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static Audio.Audio.playSound;

public class gameFrame extends JFrame {

    public gameFrame() {

        this.add(new gamePanel()); // adding game panel

        // Game Frame initialization

        try {
            BufferedImage iconImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Images/ping-pong.png")));
            this.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setTitle(Constants.TITLE);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        if (Constants.SOUND.equals("Y") || Constants.SOUND.equals("y")) {
            playSound("src/Sounds/background.wav");
        }

        closeFrameAfter_1_Minute();
    }

    public void closeFrameAfter_1_Minute() {

        Timer timer = new Timer(60 * 1000, e -> showTimeUpFrame());
        Timer Breaker = new Timer(60 * 1000, e -> Constants.BREAK = true);

        timer.setRepeats(false);
        timer.start();

        Breaker.setRepeats(false);
        Breaker.start();
    }

    public void showTimeUpFrame() {

        JFrame timeUpFrame = new JFrame(Constants.TITLE);

        try {
            BufferedImage iconImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Images/time.png")));
            timeUpFrame.setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        timeUpFrame.setSize(300, 100);
        timeUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timeUpFrame.setLocationRelativeTo(this);
        timeUpFrame.getContentPane().setBackground(Color.BLACK);

        playSound("src/Sounds/timesUp.wav");

        JLabel label = new JLabel("TIME'S UP");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setForeground(Color.RED);
        label.setFont(new Font("DialogInput", Font.BOLD, 24));

        timeUpFrame.add(label);
        timeUpFrame.setVisible(true);

        this.dispose();
    }
}
