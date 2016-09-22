package me.itselliott.chess.game.board;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;

public class Board {

    private static BiMap<Vector2n, Square> board;

    static {
        board = HashBiMap.create();
        boolean white = true;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board.put(Vector2n.valueOf(i,j), new Square(null, white ? Player.WHITE : Player.BLACK, i , j));
                white = !white;
            }
            white = !white;
        }
    }

    public static void setSquare(Vector2n positionVector, Piece piece) {
        if (board.containsKey(positionVector)) {
            board.get(positionVector).setPiece(piece);
            if (piece != null) piece.setPositionVector(positionVector);
        }
    }

    public static Square getSquare(Vector2n positionVector) {
        return board.get(positionVector);
    }


    public static BiMap<Vector2n, Square> getBoard() {
        return board;
    }


}
