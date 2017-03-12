package me.itselliott.chess.game.board.gui;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.Square;

public class Click implements EventHandler<MouseEvent> {

    private Square square;

    public Click(Square square) {
        this.square = square;
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == this.square.getRectangle()) {
            // Debug code
            System.out.println("Active Piece: " + GameHandler.getCurrentPiece().toString());
            GameHandler.getStateMachine().getCurrentState().onMouseClick(event, square);
            System.out.println("Turn: " + GameHandler.getCurrentTurn());
            System.out.println("State: " + GameHandler.getStateMachine().getCurrentState().getClass().getSimpleName());
            System.out.println("Active Piece: " + GameHandler.getCurrentPiece().toString());
        }
    }
}
