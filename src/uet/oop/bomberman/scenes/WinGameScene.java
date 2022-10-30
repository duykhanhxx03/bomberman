package uet.oop.bomberman.scenes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uet.oop.bomberman.graphics.Sprite;

public class WinGameScene {
    private Scene winGameScene;

    private static final WinGameScene instance = new WinGameScene();

    public static WinGameScene getInstance() {
        return instance;
    }

    private WinGameScene() {

    }

    public void createContent(int sceneWidth, int sceneHeight, Font font) {
        BorderPane borderPane = new BorderPane();
        Text youWinText = new Text("YOU WIN");
        youWinText.setFont(font);
        youWinText.setFill(Color.GHOSTWHITE);
        borderPane.setCenter(youWinText);

        winGameScene = new Scene(borderPane, Sprite.SCALED_SIZE * sceneWidth,
                Sprite.SCALED_SIZE * sceneHeight);
        winGameScene.setFill(Color.BLACK);
    }

    public Scene getWinGameScene() {
        return winGameScene;
    }
}
