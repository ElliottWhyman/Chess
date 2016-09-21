package me.itselliott.chess.piece;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.pieces.*;

public class PieceHandler {

    private PieceHandler() {

    }


    public static void addAllPieces() {
        Board.setSquare(Vector2n.valueOf(0,0), new Rook(Vector2n.valueOf(0,0), Player.WHITE, PieceIcon.ROOK_WHITE));
        Board.setSquare(Vector2n.valueOf(1,0), new Knight(Vector2n.valueOf(1,0), Player.WHITE, PieceIcon.KNIGHT_WHITE));
        Board.setSquare(Vector2n.valueOf(2,0), new Bishop(Vector2n.valueOf(2,0), Player.WHITE, PieceIcon.BISHOP_WHITE));
        Board.setSquare(Vector2n.valueOf(3,0), new King(Vector2n.valueOf(3,0), Player.WHITE, PieceIcon.KING_WHITE));
        Board.setSquare(Vector2n.valueOf(4,0), new Queen(Vector2n.valueOf(4,0), Player.WHITE, PieceIcon.QUEEN_WHITE));
        Board.setSquare(Vector2n.valueOf(5,0), new Rook(Vector2n.valueOf(5,0), Player.WHITE, PieceIcon.ROOK_WHITE));
        Board.setSquare(Vector2n.valueOf(6,0), new Knight(Vector2n.valueOf(6,0), Player.WHITE, PieceIcon.KNIGHT_WHITE));
        Board.setSquare(Vector2n.valueOf(7,0), new Bishop(Vector2n.valueOf(7,0), Player.WHITE, PieceIcon.BISHOP_WHITE));

        Board.setSquare(Vector2n.valueOf(7,7), new Rook(Vector2n.valueOf(7,7), Player.BLACK, PieceIcon.ROOK_BLACK));
        Board.setSquare(Vector2n.valueOf(6,7), new Knight(Vector2n.valueOf(6,7), Player.BLACK, PieceIcon.KNIGHT_BLACK));
        Board.setSquare(Vector2n.valueOf(5,7), new Bishop(Vector2n.valueOf(5,7), Player.BLACK, PieceIcon.BISHOP_BLACK));
        Board.setSquare(Vector2n.valueOf(4,7), new Bishop(Vector2n.valueOf(4,7), Player.BLACK, PieceIcon.KING_BLACK));
        Board.setSquare(Vector2n.valueOf(3,7), new Queen(Vector2n.valueOf(3,7), Player.BLACK, PieceIcon.QUEEN_BLACK));
        Board.setSquare(Vector2n.valueOf(2,7), new Rook(Vector2n.valueOf(2,7), Player.BLACK, PieceIcon.ROOK_BLACK));
        Board.setSquare(Vector2n.valueOf(1,7), new Knight(Vector2n.valueOf(1,7), Player.BLACK, PieceIcon.KNIGHT_BLACK));
        Board.setSquare(Vector2n.valueOf(0,7), new Bishop(Vector2n.valueOf(0,7), Player.BLACK, PieceIcon.BISHOP_BLACK));

        Board.setSquare(Vector2n.valueOf(0,1), new Pawn(Vector2n.valueOf(0,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(1,1), new Pawn(Vector2n.valueOf(1,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(2,1), new Pawn(Vector2n.valueOf(2,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(3,1), new Pawn(Vector2n.valueOf(3,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(4,1), new Pawn(Vector2n.valueOf(4,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(5,1), new Pawn(Vector2n.valueOf(5,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(6,1), new Pawn(Vector2n.valueOf(6,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(7,1), new Pawn(Vector2n.valueOf(7,1), Player.WHITE, PieceIcon.PAWN_WHITE));
        Board.setSquare(Vector2n.valueOf(0,6), new Pawn(Vector2n.valueOf(0,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(1,6), new Pawn(Vector2n.valueOf(1,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(2,6), new Pawn(Vector2n.valueOf(2,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(3,6), new Pawn(Vector2n.valueOf(3,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(4,6), new Pawn(Vector2n.valueOf(4,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(5,6), new Pawn(Vector2n.valueOf(5,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(6,6), new Pawn(Vector2n.valueOf(6,6), Player.BLACK, PieceIcon.PAWN_BLACK));
        Board.setSquare(Vector2n.valueOf(7,6), new Pawn(Vector2n.valueOf(7,6), Player.BLACK, PieceIcon.PAWN_BLACK));
    }

}
