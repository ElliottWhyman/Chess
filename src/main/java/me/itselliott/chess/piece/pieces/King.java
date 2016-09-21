package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.PieceIcon;

import java.util.Set;

public class King extends Queen {

    public King(Vector2n positionVector, Player player, PieceIcon icon) {
        super(positionVector, player, icon);
    }

    @Override
    public boolean canMove(Vector2n positionVector) {
        return super.canMove(positionVector, 1);
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return super.getUnitMoveVectors();
    }
}
