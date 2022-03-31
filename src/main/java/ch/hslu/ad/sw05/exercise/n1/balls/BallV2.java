package ch.hslu.ad.sw05.exercise.n1.balls;

import java.util.Random;

public class BallV2 {
    private static final int DIAMETER_OFFSET = 20;
    private static final int DIAMETER_RANGE = 30;
    private static final int MAX_SPEED = 10;
    private static final int CANVAS_WIDTH = 550;
    private static final int Y_OFFSET = 5;
    private static final Random RANDOM = new Random();
    private final static String[] COLORS = {"red", "black", "blue", "yellow", "green", "magenta"};

    private Circle circle;
    private int fallSpeed;

    public BallV2() {
        this.circle = new Circle(RANDOM.nextInt(DIAMETER_RANGE) + DIAMETER_OFFSET, RANDOM.nextInt(CANVAS_WIDTH),
                Y_OFFSET, getRandomColor());
    }

    private String getRandomColor() {
        int random = RANDOM.nextInt(6);
        return COLORS[random];
    }
}
