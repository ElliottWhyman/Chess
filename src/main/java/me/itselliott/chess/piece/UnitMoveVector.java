package me.itselliott.chess.piece;

import me.itselliott.chess.math.Vector2n;

public enum UnitMoveVector {
    UP(Vector2n.valueOf(0, 1)),
    DOWN(Vector2n.valueOf(0, -1)),
    LEFT(Vector2n.valueOf(-1, 0)),
    RIGHT(Vector2n.valueOf(1,0)),
    LEFT_DIAGONAL_UP(Vector2n.valueOf(-1,1)),
    RIGHT_DIAGONAL_UP(Vector2n.valueOf(1,1)),
    LEFT_DIAGONAL_DOWN(Vector2n.valueOf(-1,-1)),
    RIGHT_DIAGONAL_DOWN(Vector2n.valueOf(1,-1));

    Vector2n unitVector;

    UnitMoveVector(Vector2n unitVector) {
        this.unitVector = unitVector;
    }

    public Vector2n getUnitVector() {
        return this.unitVector;
    }
}
