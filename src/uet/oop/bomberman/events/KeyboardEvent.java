package uet.oop.bomberman.events;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardEvent implements EventHandler<KeyEvent> {
    private boolean isKeyUp = false;
    private boolean isKeyDown = false;
    private boolean isKeyLeft = false;
    private boolean isKeyRight = false;
    private boolean isKeySpace = false;

    private boolean isKeyB = false;
    private boolean isKeyP = false;
    private boolean isKeyR = false;


    public KeyboardEvent(Scene scene) {
        scene.setOnKeyPressed(this);
        scene.setOnKeyReleased(this);
    }

    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType().equals(KeyEvent.KEY_PRESSED)) {
            switch (event.getCode()) {
                case A:
                case LEFT:
                    isKeyLeft = true;
                    break;
                case D:
                case RIGHT:
                    isKeyRight = true;
                    break;
                case S:
                case DOWN:
                    isKeyDown = true;
                    break;
                case W:
                case UP:
                    isKeyUp = true;
                    break;
                case P:
                    isKeyP = true;
                    break;
                case R:
                    isKeyR = true;
                    break;
                case B:
                    isKeyB = true;
                    break;
                case SPACE:
                    isKeySpace = true;
                    break;
            }
        } else if (event.getEventType().equals(KeyEvent.KEY_RELEASED)) {
            switch (event.getCode()) {
                case A:
                case LEFT:
                    isKeyLeft = false;
                    break;
                case D:
                case RIGHT:
                    isKeyRight = false;
                    break;
                case S:
                case DOWN:
                    isKeyDown = false;
                    break;
                case W:
                case UP:
                    isKeyUp = false;
                    break;
                case P:
                    isKeyP = false;
                    break;
                case R:
                    isKeyR = false;
                    break;
                case B:
                    isKeyB = false;
                    break;
                case SPACE:
                    isKeySpace = false;
                    break;
            }
        }
    }

    public boolean isPressed(KeyCode keys) {
        boolean result = false;
        switch (keys) {
            case A:
            case LEFT:
                result = isKeyLeft;
                break;
            case S:
            case DOWN:
                result = isKeyDown;
                break;
            case D:
            case RIGHT:
                result = isKeyRight;
                break;
            case W:
            case UP:
                result = isKeyUp;
                break;
            case SPACE:
                result = isKeySpace;
                break;
            case P:
                result = isKeyP;
                break;
            case R:
                result = isKeyR;
                break;
            case B:
                result = isKeyB;
                break;
        }
        return result;
    }

}
