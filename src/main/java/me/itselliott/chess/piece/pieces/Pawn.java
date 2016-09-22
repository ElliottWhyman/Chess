package me.itselliott.chess.piece.pieces;

import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece implements Promotable {

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
    public void promote(Piece promoting, Piece promoteTo, Square to) {
        promoting.move(to);
        if (to.isOccupied() && to.getPiece() != null) {
            PieceHandler.removePiece(to.getPiece());
        }
        PieceHandler.addPiece(promoteTo, to);
        System.out.println(promoteTo.getPlayer() + " has promote their " + this.getClass().getSimpleName() + " to a " + promoteTo.getClass().getSimpleName());
    }

    @Override
    public Set<Vector2n> getUnitMoveVectors() {
        return this.unitMoveVectors;
    }



}
