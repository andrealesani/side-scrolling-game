package fr.paris.saclay.sidescroller.abstraction;

import fr.paris.saclay.sidescroller.controller.GamePanel;
import fr.paris.saclay.sidescroller.utils.InputHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Background extends Drawable {

    Image backgroundImage;
    GamePanel gamePanel;
    InputHandler inputHandler;
    int numOfBackgrounds = 1;

    public Background(GamePanel gamePanel, InputHandler inputHandler) {
        this.gamePanel = gamePanel;
        this.inputHandler = inputHandler;
        direction = Direction.RIGHT;
        speed = 0;
        try {
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResourceAsStream("grasslands.png"));
        } catch (IOException e) {
            throw new RuntimeException("Couldn't find background image", e);
        }
    }

    @Override
    public void update() {
        speed = gamePanel.getPlayerSpeed() / 2;
        if ((inputHandler.rightPressed || inputHandler.upPressed || inputHandler.leftPressed)) {
            if (inputHandler.rightPressed) {
                direction = Direction.RIGHT;
                if (gamePanel.getPlayerPositionX() >= gamePanel.SCREEN_WIDTH / 2 - gamePanel.WIDTH_TILE_SIZE / 2) {
                    xPosition -= speed;
                }
            } else if (inputHandler.leftPressed) {
                direction = Direction.LEFT;
                if (gamePanel.getPlayerPositionX() <= 5) {
                    xPosition += speed;
                }
            } else {
                switch (direction) {
                    case LEFT -> {
                        direction = Direction.UP_LEFT;
                    }
                    case RIGHT -> {
                        direction = Direction.UP_RIGHT;
                    }
                    case UP_LEFT -> {
                        xPosition += speed / 2;
                    }
                    case UP_RIGHT -> {
                        xPosition -= speed / 2;
                    }
                }
            }
            if (xPosition > 0)
                xPosition = 0;
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        int pixelsOffset = -gamePanel.SCREEN_WIDTH * gamePanel.SCALE * (numOfBackgrounds - 1);
        int i;

        graphics2D.drawImage(backgroundImage, xPosition, yPosition, gamePanel.SCREEN_WIDTH * gamePanel.SCALE, gamePanel.SCREEN_HEIGHT - gamePanel.HEIGHT_TILE_SIZE, null);
        for (i = 0; i < numOfBackgrounds - 1; i++) {
            graphics2D.drawImage(backgroundImage, xPosition + gamePanel.SCREEN_WIDTH * gamePanel.SCALE * (i + 1), yPosition, gamePanel.SCREEN_WIDTH * gamePanel.SCALE, gamePanel.SCREEN_HEIGHT - gamePanel.HEIGHT_TILE_SIZE, null);
        }

        if (xPosition < pixelsOffset) {
            numOfBackgrounds++;
        }
    }
}
