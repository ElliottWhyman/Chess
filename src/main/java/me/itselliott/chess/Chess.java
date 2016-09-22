package me.itselliott.chess;

import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.gui.ChessWindow;
import me.itselliott.chess.piece.PieceHandler;
import me.itselliott.chess.piece.pieces.Queen;

public class Chess {

    private ChessWindow window;

    public Chess() {
        this.window = new ChessWindow();
        Board board = new Board();
    }

    public ChessWindow getWindow() {
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
        PieceHandler.removePiece(PieceHandler.getPieceByPlayer(Queen.class, Player.WHITE));
        chess.getWindow().open();

    }


}
