package me.itselliott.chess.piece;

import me.itselliott.chess.game.GameHandler;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.game.board.Board;
import me.itselliott.chess.game.board.Square;
import me.itselliott.chess.game.board.gui.Window;
import me.itselliott.chess.math.Vector2n;

import java.util.Set;
import java.util.stream.Collectors;

public abstract class Piece {

    private Vector2n positionVector;
    private Player player;
    private PieceIcon pieceIcon;

    public Piece(Vector2n positionVector, Player player, PieceIcon icon) {
        this.positionVector = positionVector;
        this.player = player;
        this.pieceIcon = icon;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Vector2n getPositionVector() {
        return this.positionVector;
    }

    public PieceIcon getPieceIcon() {
        return this.pieceIcon;
    }

    protected boolean canMove(Vector2n positionVector, int reach) {
        for (Vector2n unitVector : this.getUnitMoveVectors()) {
            Vector2n vector = this.positionVector;
            for (int i = 0; i < reach; i++) {
                vector = (this.player == Player.WHITE ? vector.add(unitVector) : vector.subtract(unitVector));
                Square square = Board.getSquare(vector);
                if (vector.getCartesianX() > 8 || vector.getCartesianY() > 8 || vector.getCartesianX() < 0 || vector.getCartesianY() < 0) {
                    break;
                }
                if (square != null && square.isOccupied()) {
                    // TODO: Handle piece capturing
                    break;
                }
                if (vector.equals(positionVector) && !Board.getSquare(positionVector).isOccupied()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void move(Square to) {
        if (to.isOccupied()) {
            // TODO: Handle piece capturing
        } else {
            Window.moveIcon(Board.getSquare(this.getPositionVector()), to);
            Board.setSquare(this.getPositionVector(), null);
            Board.setSquare(to.getPositionVector(), this);
            this.positionVector = to.getPositionVector();
        }
    }

    public abstract boolean canMove(Vector2n positionVector);

    public Set<Square> getMoves() {
        return Board.getBoard().values().stream().filter(square -> this.canMove(square.getPositionVector()) && !square.getPositionVector().equals(this.positionVector)).collect(Collectors.toSet());
    }

    @Override
    public String toString() {
        return "Piece:[" + this.getClass().getSimpleName() + ", " + this.positionVector.toString() +"]";
    }

    public abstract Set<Vector2n> getUnitMoveVectors();

}

