package me.itselliott.chess.game.state.states;

import javafx.scene.input.MouseEvent;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.Condition;
import me.itselliott.chess.piece.pieces.NoPiece;

public class TurnStart extends Playing {

    @Override
    public void initalise() {
        GameHandler.queryCheck(GameHandler.getCurrentTurn());
    }

    @Override
    public void move(Square to) {

    }

    @Override
    public void onMouseClick(MouseEvent event, Square square) {
        if (square.isOccupied()) {
            if (GameHandler.getCurrentPiece() instanceof NoPiece && square.getPiece().getPlayer().equals(GameHandler.getCurrentTurn())) {
                GameHandler.setCurrentPiece(square.getPiece());
                GameHandler.getStateMachine().nextState(Condition.PIECE_SELECTION);
            }

        }
    }

}
