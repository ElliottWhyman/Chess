package me.itselliott.chess.game;

public enum Player {
    WHITE, BLACK;

    public static Player inverse(Player player) {
        switch (player) {
            case WHITE: return BLACK;
            case BLACK: return WHITE;
            default: return WHITE;
        }
    }
}