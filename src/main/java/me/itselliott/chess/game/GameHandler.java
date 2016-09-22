package me.itselliott.chess.game;

import me.itselliott.chess.piece.Piece;
import org.jetbrains.annotations.Nullable;

public class GameHandler {

    private static Player currentTurn;
    private static @Nullable Piece activePiece;
    private static GameState gameState;

    private GameHandler() {

    }

    static {
        currentTurn = Player.WHITE;
        gameState = GameState.NOT_PLAYING;
    }

    public static Player getCurrentTurn() {
        return currentTurn;
    }

    @Nullable
    public static Piece getActivePiece() {
        return activePiece;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        GameHandler.gameState = gameState;
        System.out.println(gameState.toString());
    }

    public static void setCurrentTurn(Player currentTurn) {
        GameHandler.currentTurn = currentTurn;
        System.out.println("Turn: " + currentTurn.toString().toLowerCase());
    }

    public static void setActivePiece(@Nullable Piece activePiece) {
        GameHandler.activePiece = activePiece;
    }

    public enum GameState {
        PLAYING, WAITING, NOT_PLAYING
    }
}


