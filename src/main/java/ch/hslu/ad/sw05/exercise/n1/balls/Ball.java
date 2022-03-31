package ch.hslu.ad.sw05.exercise.n1.balls;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public final class Ball implements Runnable{

    private static final Random RANDOM = new Random();
    private static final int DIAMETER_OFFSET = 20;
    private Circle circle;
    private final int fallSpeed;


    private static final Logger LOG = LogManager.getLogger(Ball.class);

    public Ball() {
        this.circle = new Circle(RANDOM.nextInt(31) + DIAMETER_OFFSET, RANDOM.nextInt(550), 5, getRandomColor());
        this.fallSpeed = RANDOM.nextInt(10) + 1;
    }

    private String getRandomColor() {
        int random = RANDOM.nextInt(6);
        switch (random) {
            case 0:
                return "red";
            case 1:
                return "black";
            case 2:
                return "blue";
            case 3:
                return "yellow";
            case 4:
                return "green";
            case 5:
                return "magenta";
            default:
                return "";
        }
    }

    @Override
    public String toString() {
        return "Ball{" +
                "circle=" + circle +
                '}';
    }

    @Override
    public void run() {
        this.circle.makeVisible();
        this.circle.slowMoveVertical(400, fallSpeed);
        return;
    }
}
