package UI_Open_Window;

import Constants.Constants;
import UI.gameFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static Audio.Audio.playSound;

public class loadingScreen {

    JFrame frame;
    JProgressBar bar;
    JLabel label;

    public loadingScreen() {

        // Initialize frame
        frame = new JFrame(Constants.TITLE);

        try {
            BufferedImage iconImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/Images/loading-bar.png"))); // Load the icon image
            frame.setIconImage(iconImage); // Set the icon image
        } catch (IOException e) {
            e.printStackTrace();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(Constants.LOAD_SCREEN_SIZE);
        frame.setLocationRelativeTo(null); // Center the frame

        // Initialize progress bar
        bar = new JProgressBar(0, 100);
        bar.setPreferredSize(new Dimension(Constants.LOAD_SCREEN_WIDTH, Constants.BAR_HEIGHT));
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.RED);
        bar.setBackground(Color.BLACK);

        // Initialize loading text
        label = new JLabel("LOADING PONG GAME");
        label.setForeground(Color.RED);
        label.setFont(new Font("Monospaced", Font.PLAIN, 40));
        label.setHorizontalAlignment(JLabel.CENTER);

        // Initialize loading panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.setPreferredSize(Constants.LOAD_SCREEN_SIZE);
        panel.setBackground(Color.BLACK);
        panel.setFocusable(true);
        panel.add(label, BorderLayout.CENTER);
        panel.add(bar, BorderLayout.SOUTH);

        // Add panel to frame
        frame.getContentPane().setBackground(Color.BLACK);
        frame.add(panel);

        // Show the frame
        frame.setVisible(true);

        fill();
    }

    // To get Progress :)
    public void fill() {
        byte counter = 0;
        while (counter <= 100) {

            bar.setValue(counter);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            counter++;

            if (counter == 15) {
                 playSound("src/Sounds/open.wav");
            }

            if (counter == 65) {
                Constants.SOUND = JOptionPane.showInputDialog(frame, "Wanna Have Background Music? Enter 'y' to have it or 'n' to not.", null);
            }

            if (counter == 95) {
                Constants.CHOOSE = JOptionPane.showInputDialog(frame, "Wanna Have Difficulty? Enter 'y' to have it or 'n' to not.", null);
            }
        }

        frame.dispose();
        new gameFrame();
    }
}
