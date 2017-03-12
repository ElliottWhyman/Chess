package me.itselliott.chess.game.state.states;

import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.state.Condition;
import me.itselliott.chess.game.state.State;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.pieces.NoPiece;

import java.util.HashSet;
import java.util.Set;

public class Playing extends State {

    @Override
    public void initalise() {
    }

    @Override
    public void move(Square to) {
        if (GameHandler.getCurrentPiece().getPlayer().equals(GameHandler.getCurrentTurn()) && !(GameHandler.getCurrentPiece() instanceof NoPiece)) {
            GameHandler.getCurrentPiece().move(to);
            GameHandler.getStateMachine().nextState(Condition.TURN_END);
            GameHandler.setCurrentPiece(Piece.empty());
        }
    }

    @Override
    public void onMouseClick(MouseEvent event, Square square) {
        if (GameHandler.getCurrentPiece().canMove(square.getPositionVector())) {
            move(square);
        } else if (square.isOccupied() && square.getPiece().getPlayer().equals(GameHandler.getCurrentTurn())) {
            if (GameHandler.getCurrentPiece() == square.getPiece()) {
                GameHandler.setCurrentPiece(Piece.empty());
                GameHandler.getStateMachine().nextState(Condition.DROP_SELECTION);
            } else {
                GameHandler.setCurrentPiece(square.getPiece());
            }

        }
    }



    @Override
    public void shiftOverlay(boolean toggle) {
        Set<Square> squares = new HashSet<>();
        for(Piece piece : PieceHandler.getActivePieces(GameHandler.getCurrentTurn())) {
            squares.addAll(piece.getMoves());
        }
        if (!(GameHandler.getCurrentPiece() instanceof NoPiece)) {
            squares = GameHandler.getCurrentPiece().getMoves();
        }
            for (Square square : squares) {
                if (toggle) {
                    if (square.isOccupied() && square.getPiece().getPlayer().equals(Player.inverse(GameHandler.getCurrentTurn()))) square.getRectangle().setFill(Color.RED);
                    else square.getRectangle().setFill(Color.LIGHTBLUE);
                } else {
                    Board.colourSquare(square);
                }
            }
        }

}
