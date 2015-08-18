package com.fhtw.mes1.aet.java_intro.schwarz_leonhardt.Game.ValueObjects;

/**
 * Created by leonhardt on 17.08.15.
 */
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    /**
     * @return Returns a hash code value for this object.
     */
    @Override
    public int hashCode() {
        // Implementation as in "Effective Java 2nd edition, Chapter 3"
        int result = this.x ^ (this.x >>> 32);
        result = 31 * result + (this.y ^ (this.y >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Coordinate))
            return false;
        Coordinate coordinate = (Coordinate) o;
        return this.x == coordinate.x && this.y == coordinate.y;
    }

}
