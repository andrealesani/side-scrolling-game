package fr.paris.saclay.sidescroller.utils;

import fr.paris.saclay.sidescroller.abstraction.Direction;

public class Constants {
    public static final int ORIGINAL_SQUARE_TILE = 16;
    public static final int MAX_SCREEN_COL = 16;
    public static final int MAX_SCREEN_ROWS = 12;
    public static final int SCALE = 4;
    //TODO SCALING BASED ON DEVICE
    public static final int WIDTH_TILE_SIZE = ORIGINAL_SQUARE_TILE * SCALE;
    public static final int SCREEN_WIDTH = WIDTH_TILE_SIZE * MAX_SCREEN_COL;
    public static final int HEIGHT_TILE_SIZE = ORIGINAL_SQUARE_TILE * SCALE;
    public static final int SCREEN_HEIGHT = HEIGHT_TILE_SIZE * MAX_SCREEN_ROWS;
    public static final int PLAYER_MAX_HP = 6;

    public static final int PLAYER_MAX_STAMINA = 100;

    public static final int PLAYER_STAMINA_TIMER = 90;

    public static final String PRIMARY_COLOR = "#3c1f30";

    public static final String SECONDARY_COLOR = "#fcc760";

    public static final int PLAYER_INVINCIBILITY_TIME = 90;

    public static final int CAMERA_MIN_LEFT = 300;

    public static final int CAMERA_MIN_RIGHT = SCREEN_WIDTH / 2 - WIDTH_TILE_SIZE / 2;

    public static Direction getOppositeDirection(Direction direction) {
        Direction finalDirection = null;
        switch (direction) {
            case RIGHT -> finalDirection = Direction.LEFT;
            case UP_RIGHT -> finalDirection = Direction.UP_LEFT;
            case ATTACK_RIGHT -> finalDirection = Direction.ATTACK_LEFT;
            case BLOCK_RIGHT -> finalDirection = Direction.BLOCK_LEFT;
        }
        return finalDirection;
    }
}
