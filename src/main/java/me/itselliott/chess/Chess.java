package me.itselliott.chess;

import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.board.gui.ChessWindow;
import me.itselliott.chess.piece.PieceHandler;

public class Chess {

    private ChessWindow window;

    public Chess() {
        this.window = new ChessWindow();
    }

    public ChessWindow getWindow() {
        return this.window;
    }


    public static void main(String[] args) {
        Chess chess = new Chess();
        PieceHandler.addAllPieces();
        GameHandler.start();
        chess.getWindow().open();


    }


}
