package uet.oop.bomberman;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import uet.oop.bomberman.controllers.Game;

public class BombermanGame extends Application {

    @Override
    public void start(Stage stage) {
        Game game = Game.getInstance();
        game.createGame(stage);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:res/textures/bomb.png"));
        stage.setTitle("Bomberman 6972");
        stage.show();
        game.start();
    }

}
