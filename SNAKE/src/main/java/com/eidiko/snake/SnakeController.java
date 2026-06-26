package com.eidiko.snake;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

/**
 * Snake Game Controller - Main game logic and rendering
 * Production-level implementation with proper state management and error handling
 */
public class SnakeController {
    @FXML
    private Canvas canvas;

    @FXML
    private Label scoreLabel;

    private GraphicsContext gc;
    private List<Point> snake;
    private Point food;
    private Direction nextDirection;
    private Direction currentDirection;
    private int score;
    private AnimationTimer timer;
    private GameState gameState;
    private long currentGameSpeed; // Dynamic game speed

    // Game Constants
    private static final int TILE_SIZE = 20;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final long INITIAL_GAME_SPEED_MS = 250_000_000L; // 250ms - Start slow
    private static final long MIN_GAME_SPEED_MS = 100_000_000L; // 100ms - Maximum speed
    private static final long SPEED_INCREMENT_MS = 10_000_000L; // 10ms increase per point
    private static final int INITIAL_SNAKE_LENGTH = 3;

    // Colors
    private static final Color BACKGROUND_COLOR = Color.BLACK;
    private static final Color SNAKE_HEAD_COLOR = Color.LIMEGREEN;
    private static final Color SNAKE_BODY_COLOR = Color.GREEN;
    private static final Color FOOD_COLOR = Color.RED;
    private static final Color TEXT_COLOR = Color.WHITE;
    private static final Color GAME_OVER_COLOR = Color.RED;

    /**
     * Enum for game state management
     */
    public enum GameState {
        PLAYING, PAUSED, GAME_OVER
    }

    /**
     * Enum for snake movement direction
     */
    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    /**
     * Inner class representing a coordinate point
     */
    public static class Point {
        public final int x;
        public final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    /**
     * Initialize the game on application startup
     */
    @FXML
    public void initialize() {
        try {
            if (canvas == null || scoreLabel == null) {
                throw new IllegalStateException("Canvas or ScoreLabel FXML components are not properly injected");
            }

            gc = canvas.getGraphicsContext2D();
            initializeGame();
            startGameLoop();
        } catch (Exception e) {
            System.err.println("Error initializing game: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Initialize or reset game variables
     */
    private void initializeGame() {
        snake = new ArrayList<>();
        for (int i = 0; i < INITIAL_SNAKE_LENGTH; i++) {
            snake.add(new Point(WIDTH / 2 - (i * TILE_SIZE), HEIGHT / 2));
        }
        currentDirection = Direction.RIGHT;
        nextDirection = Direction.RIGHT;
        score = 0;
        gameState = GameState.PLAYING;
        currentGameSpeed = INITIAL_GAME_SPEED_MS;
        updateScoreLabel();
        generateFood();
    }

    /**
     * Start or resume the game animation loop
     */
    private void startGameLoop() {
        if (timer != null) {
            timer.stop();
        }

        timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                try {
                    if (gameState == GameState.PLAYING) {
                        if (now - lastUpdate >= currentGameSpeed) {
                            update();
                            lastUpdate = now;
                        }
                    }
                    draw();
                } catch (Exception e) {
                    System.err.println("Error in game loop: " + e.getMessage());
                    setGameOver();
                }
            }
        };
        timer.start();
    }

    /**
     * Update game state for each frame
     */
    private void update() {
        if (gameState != GameState.PLAYING) {
            return;
        }

        // Update direction
        currentDirection = nextDirection;

        // Calculate new head position
        Point head = snake.get(0);
        Point newHead = calculateNewHead(head, currentDirection);

        // Check collision with walls or self
        if (isCollision(newHead)) {
            setGameOver();
            return;
        }

        // Add new head
        snake.add(0, newHead);

        // Check food collision
        if (newHead.equals(food)) {
            score++;
            updateScoreLabel();
            generateFood();
            increaseGameSpeed(); // Increase speed on food collision
        } else {
            // Remove tail if no food eaten
            snake.remove(snake.size() - 1);
        }
    }

    /**
     * Calculate new head position based on direction
     */
    private Point calculateNewHead(Point head, Direction direction) {
        return switch (direction) {
            case UP -> new Point(head.x, head.y - TILE_SIZE);
            case DOWN -> new Point(head.x, head.y + TILE_SIZE);
            case LEFT -> new Point(head.x - TILE_SIZE, head.y);
            case RIGHT -> new Point(head.x + TILE_SIZE, head.y);
        };
    }

    /**
     * Check if position collides with walls or snake body
     */
    private boolean isCollision(Point point) {
        // Wall collision
        if (point.x < 0 || point.x >= WIDTH || point.y < 0 || point.y >= HEIGHT) {
            return true;
        }

        // Self collision
        for (Point p : snake) {
            if (p.equals(point)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Render the game
     */
    private void draw() {
        try {
            // Draw background
            gc.setFill(BACKGROUND_COLOR);
            gc.fillRect(0, 0, WIDTH, HEIGHT);

            // Draw snake
            drawSnake();

            // Draw food
            drawFood();

            // Draw game state overlay if needed
            if (gameState == GameState.GAME_OVER) {
                drawGameOverScreen();
            } else if (gameState == GameState.PAUSED) {
                drawPauseScreen();
            }
        } catch (Exception e) {
            System.err.println("Error drawing game: " + e.getMessage());
        }
    }

    /**
     * Draw snake with head differentiation
     */
    private void drawSnake() {
        for (int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            if (i == 0) {
                // Draw head with different color
                gc.setFill(SNAKE_HEAD_COLOR);
                gc.fillOval(p.x + 2, p.y + 2, TILE_SIZE - 4, TILE_SIZE - 4);
                // Draw eyes
                gc.setFill(Color.BLACK);
                int eyeOffset = 2;
                gc.fillOval(p.x + eyeOffset + 2, p.y + eyeOffset + 2, 3, 3);
                gc.fillOval(p.x + TILE_SIZE - eyeOffset - 5, p.y + eyeOffset + 2, 3, 3);
            } else {
                // Draw body
                gc.setFill(SNAKE_BODY_COLOR);
                gc.fillRoundRect(p.x + 1, p.y + 1, TILE_SIZE - 2, TILE_SIZE - 2, 6, 6);
            }
        }
    }

    /**
     * Draw food
     */
    private void drawFood() {
        gc.setFill(FOOD_COLOR);
        gc.fillOval(food.x + 4, food.y + 4, TILE_SIZE - 8, TILE_SIZE - 8);
        // Add shine effect
        gc.setFill(Color.YELLOW);
        gc.fillOval(food.x + 6, food.y + 6, 4, 4);
    }

    /**
     * Draw game over overlay
     */
    private void drawGameOverScreen() {
        gc.setFill(Color.color(0, 0, 0, 0.7));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(GAME_OVER_COLOR);
        gc.setFont(javafx.scene.text.Font.font(30));
        gc.fillText("GAME OVER!", WIDTH / 2.0 - 70, HEIGHT / 2.0 - 20);

        gc.setFill(TEXT_COLOR);
        gc.setFont(javafx.scene.text.Font.font(16));
        gc.fillText("Press SPACE to restart", WIDTH / 2.0 - 80, HEIGHT / 2.0 + 20);
    }

    /**
     * Draw pause overlay
     */
    private void drawPauseScreen() {
        gc.setFill(Color.color(0, 0, 0, 0.5));
        gc.fillRect(0, 0, WIDTH, HEIGHT);

        gc.setFill(TEXT_COLOR);
        gc.setFont(javafx.scene.text.Font.font(24));
        gc.fillText("PAUSED", WIDTH / 2.0 - 50, HEIGHT / 2.0);

        gc.setFont(javafx.scene.text.Font.font(14));
        gc.fillText("Press SPACE to resume", WIDTH / 2.0 - 70, HEIGHT / 2.0 + 40);
    }

    /**
     * Generate random food position
     */
    private void generateFood() {
        Point newFood;
        do {
            int x = (int) (Math.random() * (WIDTH / TILE_SIZE)) * TILE_SIZE;
            int y = (int) (Math.random() * (HEIGHT / TILE_SIZE)) * TILE_SIZE;
            newFood = new Point(x, y);
        } while (snake.contains(newFood));

        food = newFood;
    }

    /**
     * Set game to over state
     */
    private void setGameOver() {
        gameState = GameState.GAME_OVER;
        updateScoreLabel();
    }

    /**
     * Update score label in UI
     */
    private void updateScoreLabel() {
        String stateText = gameState == GameState.GAME_OVER ? " (GAME OVER)" : "";
        scoreLabel.setText("Score: " + score + stateText);
    }

    /**
     * Handle key press events
     */
    public void handleKeyPressed(KeyEvent event) {
        try {
            KeyCode code = event.getCode();

            // Handle spacebar for pause/resume/restart
            if (code == KeyCode.SPACE) {
                if (gameState == GameState.PLAYING) {
                    gameState = GameState.PAUSED;
                } else if (gameState == GameState.PAUSED) {
                    gameState = GameState.PLAYING;
                } else if (gameState == GameState.GAME_OVER) {
                    initializeGame();
                }
                event.consume();
                return;
            }

            // Handle arrow keys only during gameplay
            if (gameState == GameState.PLAYING) {
                Direction newDirection = null;

                if (code == KeyCode.UP && currentDirection != Direction.DOWN) {
                    newDirection = Direction.UP;
                } else if (code == KeyCode.DOWN && currentDirection != Direction.UP) {
                    newDirection = Direction.DOWN;
                } else if (code == KeyCode.LEFT && currentDirection != Direction.RIGHT) {
                    newDirection = Direction.LEFT;
                } else if (code == KeyCode.RIGHT && currentDirection != Direction.LEFT) {
                    newDirection = Direction.RIGHT;
                }

                if (newDirection != null) {
                    nextDirection = newDirection;
                    event.consume();
                }
            }
        } catch (Exception e) {
            System.err.println("Error handling key press: " + e.getMessage());
        }
    }

    /**
     * Clean up resources on application close
     */
    public void shutdown() {
        if (timer != null) {
            timer.stop();
        }
    }

    /**
     * Increase game speed based on current score
     */
    private void increaseGameSpeed() {
        currentGameSpeed -= SPEED_INCREMENT_MS;
        if (currentGameSpeed < MIN_GAME_SPEED_MS) {
            currentGameSpeed = MIN_GAME_SPEED_MS;
        }
    }
}
