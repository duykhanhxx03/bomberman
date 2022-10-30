package uet.oop.bomberman.scenes;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import uet.oop.bomberman.controllers.Game;
import uet.oop.bomberman.controllers.GameStatus;
import uet.oop.bomberman.graphics.GraphicsMGR;
import uet.oop.bomberman.graphics.Sprite;

public class StartMenuScene {
    private static final StartMenuScene instance = new StartMenuScene();

    private final Scene startMenuScene;

    private StartMenuScene() {
        startMenuScene = new Scene(createContent());
    }

    private static class MenuItem extends StackPane {
        public MenuItem(String name) {
            LinearGradient gradientColor = new LinearGradient(0, 0, 1, 0, true,
                    CycleMethod.NO_CYCLE, new Stop(0, Color.DARKBLUE),
                    new Stop(0.3, Color.BLACK),
                    new Stop(0.7, Color.BLACK),
                    new Stop(1, Color.DARKBLUE));

            Rectangle background = new Rectangle(400, 75);
            background.setOpacity(0.4);

            Text text = new Text(name);
            text.setFill(Color.DARKGREY);
            text.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 60));

            setAlignment(Pos.CENTER);
            getChildren().addAll(background, text);

            setOnMouseEntered(event -> {
                background.setFill(gradientColor);
                text.setFill(Color.WHITE);
            });


            setOnMouseExited(event -> {
                background.setFill(Color.BLACK);
                text.setFill(Color.DARKGREY);
            });

            setOnMousePressed(event -> background.setFill(Color.DARKBLUE));

            setOnMouseReleased(event -> background.setFill(gradientColor));
        }
    }

    private static class MenuBox extends VBox {
        public MenuBox(MenuItem... items) {
            getChildren().add(createSeparator());

            for (MenuItem item : items) {
                getChildren().addAll(item, createSeparator());
            }
        }

        private Line createSeparator() {
            Line line = new Line();
            line.setEndX(400);
            line.setStroke(Color.DARKGREY);
            return line;
        }
    }

    private static class Title extends StackPane {
        public Title(String name) {
            Rectangle background = new Rectangle(720, 120);
            background.setStroke(Color.WHITE);
            background.setStrokeWidth(8);
            background.setFill(null);

            Text titleText = new Text(name);
            titleText.setFill(Color.WHITE);
            titleText.setFont(Font.font("Tw Cen MT Condensed", FontWeight.SEMI_BOLD, 100));

            setAlignment(Pos.CENTER);
            getChildren().addAll(background, titleText);
        }
    }

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(GraphicsMGR.WIDTH * Sprite.SCALED_SIZE,
                GraphicsMGR.HEIGHT * Sprite.SCALED_SIZE);

        Image img = new Image("file:res/textures/startmenu_bg.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(GraphicsMGR.WIDTH * Sprite.SCALED_SIZE);
        imgView.setFitHeight(GraphicsMGR.HEIGHT * Sprite.SCALED_SIZE);
        root.getChildren().add(imgView);

        Title title = new Title("B O M B E R M A N 6972");
        title.setTranslateX((GraphicsMGR.WIDTH * Sprite.SCALED_SIZE
                - title.getBoundsInLocal().getWidth()) / 2);
        title.setTranslateY((GraphicsMGR.HEIGHT * Sprite.SCALED_SIZE
                - title.getBoundsInLocal().getHeight()) / 2 - 4 * Sprite.SCALED_SIZE);

        MenuItem itemExit = new MenuItem("EXIT");
        itemExit.setOnMouseClicked(event -> System.exit(0));

        MenuItem itemStart = new MenuItem("START");
        itemStart.setOnMouseClicked(event
                -> Game.getInstance().setGameStatus(GameStatus.OPENING));

        MenuBox menu = new MenuBox(
                itemStart,
                itemExit);
        menu.setTranslateX((GraphicsMGR.WIDTH * Sprite.SCALED_SIZE
                - menu.getBoundsInLocal().getWidth()) / 2);
        menu.setTranslateY((GraphicsMGR.HEIGHT * Sprite.SCALED_SIZE
                - menu.getBoundsInLocal().getHeight()) / 2);

        root.getChildren().addAll(title, menu);
        return root;
    }

    public Scene getStartMenuScene() {
        return startMenuScene;
    }

    public static StartMenuScene getInstance() {
        return instance;
    }
}
