package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceIcon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Knight extends Piece {

    private Set<Vector2n> unitMoveVectors = new HashSet<Vector2n>();

    public Knight(Vector2n positionVector, Player player, PieceIcon icon) {
        super(positionVector, player, icon);
        this.unitMoveVectors.addAll(Arrays.asList(
                Vector2n.valueOf(-2, 1),
                Vector2n.valueOf(-1, 2),
                Vector2n.valueOf( 1, 2),
                Vector2n.valueOf( 2, 1),
                Vector2n.valueOf(2, -1),
                Vector2n.valueOf(1, -2),
                Vector2n.valueOf(-1, -2),
                Vector2n.valueOf(-2, -1)
        ));
    }

    @Override
    public boolean canMove(Vector2n positionVector) {
        return this.canMove(positionVector, 1);
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return this.unitMoveVectors;
    }
}
