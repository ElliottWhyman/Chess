package me.itselliott.chess.game.board;

import javafx.scene.shape.Rectangle;
import me.itselliott.chess.game.Player;
import me.itselliott.chess.math.Vector2n;
import me.itselliott.chess.piece.Piece;
import me.itselliott.chess.piece.pieces.NoPiece;

public class Square {

    private boolean occupied;
    private Player colour;
    private Rectangle rectangle;
    private Piece piece;
    private Vector2n positionVector;

    public Square(Piece piece, Player colour, int x, int y) {
        this.piece = piece;
        this.colour = colour;
        this.rectangle = new Rectangle(45, 45);
        this.rectangle.setX(x * 45);
        this.rectangle.setY(y * 45);
        this.occupied = !(piece instanceof NoPiece);
        this.positionVector = Vector2n.valueOf(x,y);
    }


    public Rectangle getRectangle() {
        return this.rectangle;
    }

    public Player getColour() {
        return this.colour;
    }

    public boolean isOccupied() {
        return this.occupied;
    }

    public Vector2n getPositionVector() {
        return this.positionVector;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
        this.occupied = !(piece instanceof NoPiece);
    }

    @Override
    public String toString() {
        return "Square:[" + this.positionVector.toString() + ", [occupied: " + this.occupied + (this.occupied ? ", " + this.getPiece().toString() + "]" : "") + " ]" +  "]";
    }
}
