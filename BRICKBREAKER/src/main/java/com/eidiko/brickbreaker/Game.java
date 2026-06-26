package com.eidiko.brickbreaker;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final double width;
    private final double height;
    private final GraphicsContext gc;

    private Ball ball;
    private Paddle paddle;
    private List<Brick> bricks;

    private int score;
    private int lives;
    private boolean paused;

    private AnimationTimer timer;
    private long lastTime = 0;

    public Game(double width, double height, GraphicsContext gc) {
        this.width = width;
        this.height = height;
        this.gc = gc;
        resetGame();
    }

    public void start() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                double dt = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                if (!paused) {
                    update(dt);
                }

                render();
            }
        };

        timer.start();
    }

    private void update(double dt) {
        paddle.update(dt);
        ball.update(dt);

        // wall collision
        if (ball.getX() - ball.getRadius() <= 0 || ball.getX() + ball.getRadius() >= width) {
            ball.setVx(-ball.getVx());
        }

        if (ball.getY() - ball.getRadius() <= 0) {
            ball.setVy(-ball.getVy());
        }

        // bottom - life lost
        if (ball.getY() - ball.getRadius() > height) {
            lives--;

            if (lives <= 0) {
                resetGame();
            } else {
                resetBallAndPaddle();
            }
        }

        // paddle collision
        if (Utils.rectCircleCollision(
                paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight(),
                ball.getX(), ball.getY(), ball.getRadius())) {

            ball.setVy(-Math.abs(ball.getVy()));
        }

        // brick collision
        for (Brick b : bricks) {
            if (b.isAlive() && Utils.rectCircleCollision(
                    b.getX(), b.getY(), b.getWidth(), b.getHeight(),
                    ball.getX(), ball.getY(), ball.getRadius())) {

                b.hit();
                ball.setVy(-ball.getVy());
                score += 10;
                break;
            }
        }

        // win condition
        boolean allBroken = bricks.stream().noneMatch(Brick::isAlive);
        if (allBroken) {
            buildBricks();
            resetBallAndPaddle();
        }
    }

    private void resetGame() {
        score = 0;
        lives = 3;
        paused = false;
        resetBallAndPaddle();
        buildBricks();
    }

    private void resetBallAndPaddle() {
        paddle = new Paddle(width / 2 - 50, height - 40, 100, 15, width);
        ball = new Ball(width / 2, height / 2, 10, 220, -220);
    }

    private void buildBricks() {
        bricks = new ArrayList<>();

        int rows = 5;
        int cols = 10;
        double brickWidth = 70;
        double brickHeight = 25;
        double gap = 8;
        double startX = 35;
        double startY = 60;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                double x = startX + col * (brickWidth + gap);
                double y = startY + row * (brickHeight + gap);
                bricks.add(new Brick(x, y, brickWidth, brickHeight, 1));
            }
        }
    }

    private void render() {
        gc.setFill(Color.web("#0b2545"));
        gc.fillRect(0, 0, width, height);

        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + score, 10, 20);
        gc.fillText("Lives: " + lives, width - 80, 20);

        if (paused) {
            gc.fillText("PAUSED - press SPACE to resume", width / 2.0 - 100, height / 2.0);
        }

        paddle.render(gc);
        ball.render(gc);

        for (Brick b : bricks) {
            b.render(gc);
        }
    }

    public void togglePause() {
        paused = !paused;
    }

    public Paddle getPaddle() {
        return paddle;
    }
}