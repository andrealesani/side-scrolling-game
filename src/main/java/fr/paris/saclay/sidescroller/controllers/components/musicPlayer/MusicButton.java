package fr.paris.saclay.sidescroller.controllers.components.musicPlayer;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

/**
 * Button used for the media player controls.
 */
public class MusicButton extends JButton {
    /**
     * Background image of the button.
     */
    private Image image;

    /**
     * Creates a MusicButton instance.
     *
     * @param filename file path of the image.
     */
    public MusicButton(String filename) {
        setPreferredSize(new Dimension(30, 30));
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("images/media_player/" + filename + ".png"));
            image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setIcon(new ImageIcon(image));
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setContentAreaFilled(false);
        setHorizontalTextPosition(JButton.CENTER);
        getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "none");
    }
}
