package me.itselliott.chess.math;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class Vector2n {

    private static Table<Integer, Integer, Vector2n> vectorTable = HashBasedTable.create();

    private final int x;
    private final int y;

    private Vector2n(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Vector2n add(Vector2n vector) {
        return Vector2n.valueOf(this.x + vector.x, this.y + vector.y);
    }

    public Vector2n subtract(Vector2n vector) {
        return Vector2n.valueOf(this.x - vector.x, this.y - vector.y);
    }

    public Vector2n multiply(Vector2n vector) {
        return Vector2n.valueOf(this.x * vector.x, this.y * vector.y);
    }

    public Vector2n divide(Vector2n vector) {
        return Vector2n.valueOf(this.x / vector.x, this.y / vector.y);
    }

    public double magnitudeSquared() {
        return Math.pow(this.x, 2) + Math.pow(this.y, 2);
    }

    public Vector2n normaliseAndRound() {
        int x = (int) Math.ceil(this.x / Math.sqrt(this.magnitudeSquared()));
        int y = (int) Math.ceil(this.y / Math.sqrt(this.magnitudeSquared()));
        return Vector2n.valueOf(x, y);
    }

    public int getCartesianX() {
        return this.x;
    }

    public int getCartesianY() {
        return this.y;
    }

    public static Vector2n valueOf(int x, int y) {
        Vector2n vector = vectorTable.get(x,y);
        if (vector != null)
            return vector;
        vectorTable.put(x,y, new Vector2n(x,y));
        return valueOf(x,y);
    }

    @Override
    public String toString() {
        return "Vector(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Vector2n) {
            Vector2n vector2n = (Vector2n) object;
            if (vector2n.getCartesianX() == this.getCartesianX() && vector2n.getCartesianY() == this.getCartesianY()) {
                return true;
            }
        }
        return false;
    }
}
