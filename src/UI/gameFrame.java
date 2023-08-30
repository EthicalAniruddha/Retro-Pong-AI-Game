package UI;

import Constants.Constants;

import javax.swing.*;
import java.awt.*;

public class gameFrame extends JFrame {

    public gameFrame() {

		this.add(new gamePanel()); // adding game panel

        // Game Frame initialization
		this.setTitle(Constants.TITLE);
		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.pack();
    }
}
