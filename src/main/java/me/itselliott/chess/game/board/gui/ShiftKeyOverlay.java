package me.itselliott.chess.game.board.gui;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Square;

import java.util.Set;

public class ShiftKeyOverlay implements EventHandler<KeyEvent> {

    boolean pressedOrReleased;

    public ShiftKeyOverlay(boolean pressedOrReleased) {
        this.pressedOrReleased = pressedOrReleased;
    }

    @Override
    public void handle(KeyEvent event) {
        if (GameHandler.getGameState() == GameHandler.GameState.WAITING && GameHandler.getActivePiece() != null) {
            if (event.getCode() == KeyCode.SHIFT) {
                Set<Square> squares = GameHandler.getActivePiece().getMoves();
                if (pressedOrReleased) {
                    for (Square square : squares) {
                        if (square.isOccupied()) square.getRectangle().setFill(Color.RED);
                        else square.getRectangle().setFill(Color.LIGHTBLUE);
                    }
                } else {
                    for (Square square : squares) {
                        if (square.getColour().equals(Player.BLACK)) {
                            square.getRectangle().setFill(Color.DARKGRAY);
                        } else if (square.getColour().equals(Player.WHITE)) {
                            square.getRectangle().setFill(Color.GRAY);
                        }
                        if (square.isOccupied()) {
                            square.getRectangle().setFill(new ImagePattern(new Image(square.getPiece().getPieceIcon().getLocation())));
                        }
                    }
                }
            }
        }
    }
}
