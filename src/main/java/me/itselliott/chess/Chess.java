package me.itselliott.chess;

import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.gui.Window;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.PieceIcon;
import me.itselliott.chess.piece.pieces.King;
import me.itselliott.chess.piece.pieces.Pawn;
import me.itselliott.chess.piece.pieces.Queen;

public class Chess {

    private Window window;

    public Chess() {
        this.window = new Window();
        Board board = new Board();
    }

    public Window getWindow() {
        return this.window;
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
        GameHandler.setGameState(GameHandler.GameState.PLAYING);
        /*Board.setSquare(Vector2n.valueOf(0,0), new Pawn(Vector2n.valueOf(0,0), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(0,7), new Pawn(Vector2n.valueOf(0,7), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(3,3), new Queen(Vector2n.valueOf(3,3), Player.WHITE, PieceIcon.QUEEN_WHITE));
        Board.setSquare(Vector2n.valueOf(5,3), new King(Vector2n.valueOf(5,3), Player.BLACK, PieceIcon.KING_BLACK));*/
        PieceHandler.addAllPieces();
        chess.getWindow().open();

    }


}
