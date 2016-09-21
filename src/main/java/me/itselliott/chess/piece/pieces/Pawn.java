package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.PieceIcon;
import me.itselliott.chess.piece.UnitMoveVector;

import java.util.*;

public class Pawn extends Piece {

    private Set<Vector2n> unitMoveVectors = new HashSet<Vector2n>();

    private int moves = 0;

    public Pawn(Vector2n positionVector, Player player, PieceIcon icon) {
        super(positionVector, player, icon);
        unitMoveVectors.addAll(Arrays.asList(
                UnitMoveVector.UP.getUnitVector()
        ));
    }

    @Override
    public boolean canMove(Vector2n positionVector) {
        return super.canMove(positionVector, (moves < 1 ? 2 : 1));
    }

    @Override
    public void move(Square to) {
        moves++;
        super.move(to);
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return this.unitMoveVectors;
    }
}
