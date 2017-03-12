package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;

import java.util.Collections;
import java.util.Set;

public class NoPiece extends Piece {

    public NoPiece() {
        super(null,null,null);
    }

    @Override
    public boolean canMove(Vector2n positionVector) {
        return false;
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return Collections.emptySet();
    }

    @Override
    public String toString() {
        return "NoPiece";
    }
}
