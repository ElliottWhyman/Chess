package me.itselliott.chess.game;

public enum Player {
    WHITE,BLACK;

    public static Player inverse() {
        if (GameHandler.getCurrentTurn() == WHITE) return BLACK;
        if (GameHandler.getCurrentTurn() == BLACK) return WHITE;
        else return WHITE;
    }
}
