package me.itselliott.chess.game.board;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
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
                board.put(Vector2n.valueOf(i,j), new Square(Piece.empty(), white ? Player.WHITE : Player.BLACK, i , j));
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

    public static void colourSquare(Square square) {
        if (square.getColour().equals(Player.BLACK)) {
            square.getRectangle().setFill(Color.DARKGRAY);
        } else if (square.getColour().equals(Player.WHITE)) {
            square.getRectangle().setFill(Color.GRAY);
        }
        if (square.isOccupied()) {
            square.getRectangle().setFill(new ImagePattern(new Image(square.getPiece().getPieceIcon().getLocation())));
        }
    }

    public static BiMap<Vector2n, Square> getBoard() {
        return board;
    }


}
