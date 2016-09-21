package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceIcon;
import me.itselliott.chess.piece.UnitMoveVector;

import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece {

    private Set<Vector2n> unitMoveVectors = new HashSet<Vector2n>();

    public Queen(Vector2n positionVector, Player player, PieceIcon icon) {
        super(positionVector, player, icon);
        for (UnitMoveVector unitMoveVector : UnitMoveVector.values()) {
            this.unitMoveVectors.add(unitMoveVector.getUnitVector());
        }
    }

    @Override
    public boolean canMove(Vector2n positionVector) {
        return super.canMove(positionVector, 8);
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return this.unitMoveVectors;
    }
}
