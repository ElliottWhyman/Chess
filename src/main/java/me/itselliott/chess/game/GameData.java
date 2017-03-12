package me.itselliott.chess.game;

import me.itselliott.chess.piece.Piece;

public class GameData {

    private static GameData gameData = null;

    public Piece currentPiece = Piece.empty();
    public Player currentTurn = Player.WHITE;

    private GameData() {
    }

    public static GameData getGameData() {
        if (gameData == null) {
            gameData = new GameData();
        }
        return gameData;
    }



}
