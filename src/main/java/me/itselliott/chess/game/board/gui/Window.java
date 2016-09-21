package me.itselliott.chess.game.board.gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;

public class Window extends Application {

    public void open() {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chess");
        primaryStage.setScene(new Scene(makeBoard()));
        primaryStage.show();
        primaryStage.getScene().setOnKeyPressed(new ShiftKeyOverlay(true));
        primaryStage.getScene().setOnKeyReleased(new ShiftKeyOverlay(false));
    }

    private Group makeBoard() {
        Group group = new Group();
        for (Square square : Board.getBoard().values()) {
            if (square.getColour().equals(Player.BLACK)) {
                square.getRectangle().setFill(Color.DARKGRAY);
            } else if (square.getColour().equals(Player.WHITE)) {
                square.getRectangle().setFill(Color.GRAY);
            }
            if (square.isOccupied()) {
                square.getRectangle().setFill(new ImagePattern(new Image(square.getPiece().getPieceIcon().getLocation())));
            }
            square.getRectangle().setOnMouseClicked(new ClickHandler(square));
            group.getChildren().add(square.getRectangle());
        }
        return group;
    }

    public static void moveIcon(Square from, Square to) {
        if (from.isOccupied()) {
            to.getRectangle().setFill(new ImagePattern(new Image(from.getPiece().getPieceIcon().getLocation())));
            from.getRectangle().setFill(from.getColour() == Player.WHITE ? Color.GRAY : Color.DARKGRAY );
        }
    }

}