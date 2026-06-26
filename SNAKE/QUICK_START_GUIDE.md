# Snake Game - Quick Reference Guide

## 🎮 How to Play

### Controls
- **↑ Up Arrow** - Move snake upward
- **↓ Down Arrow** - Move snake downward
- **← Left Arrow** - Move snake left
- **→ Right Arrow** - Move snake right
- **SPACE** - Pause/Resume or Restart

### Objective
Eat the red dots (food) to grow your snake and increase your score. Avoid hitting walls or yourself!

---

## 🚀 How to Run

### Using Maven (Recommended)
```powershell
cd "C:\Users\Sreenivas Bandaru\Desktop\LANGUAGE\JAVA\snake"
.\mvnw.cmd clean compile exec:java -Dexec.mainClass="com.eidiko.snake.SnakeApplication"
```

### Using Java Directly
```powershell
.\mvnw.cmd package
java -jar target/snake-game-1.0.jar
```

---

## 📊 Game Features

✅ **Real-time Score Display** - See your score at the top of the window

✅ **Professional Graphics**
- Green snake with bright head and eyes
- Red food with shine effect
- Clean black background

✅ **Smart Controls**
- Prevents illegal reverse moves
- Responsive keyboard input
- Smooth movement

✅ **Game States**
- **PLAYING**: Normal gameplay
- **PAUSED**: Game paused (press SPACE to resume)
- **GAME OVER**: Game ended (press SPACE to restart)

✅ **Advanced Collision Detection**
- Wall collision detection
- Self-collision detection
- Accurate food detection

---

## 🏆 Scoring

- Each red dot (food) eaten = +1 score
- Snake grows longer with each food
- Try to achieve the highest score!

---

## 💡 Tips & Tricks

1. **Plan Ahead**: Don't chase food blindly
2. **Use Walls**: Create a strategy using game boundaries
3. **Watch Your Tail**: Avoid hitting your own body
4. **Controlled Moves**: Use smooth, deliberate direction changes
5. **Edge Technique**: The corners can be useful for tight spaces

---

## 🛠️ System Requirements

- **Java**: 17 or higher
- **JavaFX**: 11 or higher
- **Keyboard**: With arrow keys
- **Display**: Minimum 440x460 pixels
- **RAM**: 256MB minimum

---

## 📋 Keyboard Controls Summary

| Key | Action |
|-----|--------|
| ↑ | Move Up |
| ↓ | Move Down |
| ← | Move Left |
| → | Move Right |
| SPACE | Pause/Resume/Restart |

---

## 🎯 Game Modes

This version includes:
- **Single Player Classic Mode** - Standard snake gameplay
- **Pause Feature** - Pause at any time with SPACE
- **Instant Restart** - Quick restart after game over

---

## ⚡ Performance

- **Frame Rate**: 60+ FPS rendering
- **Game Speed**: Optimal 150ms movement updates
- **Input Response**: Instant keyboard response
- **Memory**: Minimal footprint

---

## 🐛 Troubleshooting

### Game won't start
- Ensure Java 17+ is installed
- Verify JavaFX is in Maven dependencies
- Check console for error messages

### Keys not responding
- Click on the game window to ensure it has focus
- Try clicking and then pressing arrow keys

### Game runs slowly
- Close other applications
- Check your system resources
- Ensure no vsync conflicts with JavaFX

### Window won't close
- Press Alt+F4 or use task manager
- Check if resources cleanup is complete

---

## 📚 File Structure

```
snake/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/eidiko/snake/
│       │       ├── HelloApplication.java    (Main entry point)
│       │       └── HelloController.java     (Game logic)
│       └── resources/
│           └── com/eidiko/snake/
│               └── hello-view.fxml         (UI layout)
├── pom.xml                                  (Maven config)
├── mvnw                                     (Maven wrapper)
└── PRODUCTION_TEST_REPORT.md               (Test results)
```

---

## 🔐 Privacy & Security

- No internet connection required
- No data collection
- No external services
- Fully local gameplay
- Open source ready

---

## 📞 Support

For issues or questions:
1. Check the PRODUCTION_TEST_REPORT.md
2. Review error messages in console
3. Verify system requirements
4. Restart the application

---

## 🎉 Enjoy!

Have fun playing Snake! Good luck beating your high score! 🐍

---

**Version**: 1.0 Production  
**Last Updated**: May 8, 2026  
**Status**: ✅ Ready for Production

