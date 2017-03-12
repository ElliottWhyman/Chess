package me.itselliott.chess.game.state.states;

import javafx.scene.paint.Color;
import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.pieces.King;

public class Check extends Playing {

    @Override
    public void move(Square to) {
        if (GameHandler.getCurrentPiece() instanceof King) {
            super.move(to);
        } else {
            System.out.println("Must evade check!");
        }
    }

    @Override
    public void shiftOverlay(boolean toggle) {
        for (Square square : PieceHandler.getPieceByPlayer(King.class, GameHandler.getCurrentTurn()).getMoves()) {
            if (toggle) {
                if (square.isOccupied()) square.getRectangle().setFill(Color.RED);
                else square.getRectangle().setFill(Color.LIGHTBLUE);
            } else {
                Board.colourSquare(square);
            }
        }
    }


}
