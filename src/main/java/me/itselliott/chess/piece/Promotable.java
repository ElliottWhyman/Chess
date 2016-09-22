package me.itselliott.chess.piece;

import me.itselliott.chess.game.board.Square;

public interface Promotable {

    void promote(Piece promoting, Piece promoteTo, Square to);

}
