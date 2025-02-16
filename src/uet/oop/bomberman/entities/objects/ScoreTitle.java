package uet.oop.bomberman.entities.objects;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import uet.oop.bomberman.controllers.Game;

public class ScoreTitle {
    private static final ScoreTitle instance = new ScoreTitle();
    private Text currentLevel;
    private Text scoreTexture;
    private Text leftTexture;
    private int bomberLeft;

    private ScoreTitle() {
    }

    public void createScoreTitle(Group root, Font font) {
        try {
//            font = Font.font("Abyssinica SIL", FontWeight.BOLD, 80);
            currentLevel = new Text();
            scoreTexture = new Text();
            leftTexture = new Text();
            currentLevel.setText("LEVEL ");
            currentLevel.setFont(font);
            currentLevel.setFill(Color.DIMGRAY);
            currentLevel.setX(48);
            currentLevel.setY(80);

            scoreTexture.setText("SCORE ");
            scoreTexture.setFont(font);
            scoreTexture.setFill(Color.DIMGRAY);
            scoreTexture.setX(700);
            scoreTexture.setY(80);

            leftTexture.setText("LEFT ");
            leftTexture.setFont(font);
            leftTexture.setFill(Color.DIMGRAY);
            leftTexture.setX(1100);
            leftTexture.setY(80);
            root.getChildren().addAll(currentLevel, scoreTexture, leftTexture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ScoreTitle getInstance() {
        return instance;
    }

    public void update(int bomberLeft, int scoreBomber, Scene scene) {
        setBomberLeft(bomberLeft);

        leftTexture.setText("LEFT " + bomberLeft);
        scoreTexture.setText(scoreBomber + "");
        scoreTexture.setX((scene.getWidth() - scoreTexture.getBoundsInLocal().getWidth()) / 2);
        currentLevel.setText("LEVEL " + Game.getInstance().getCurrentLevel());
    }

    public int getBomberLeft() {
        return bomberLeft;
    }

    public void setBomberLeft(int bomberLeft) {
        this.bomberLeft = bomberLeft;
    }
}
