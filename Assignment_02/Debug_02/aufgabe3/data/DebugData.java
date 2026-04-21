package aufgabe3.data;

import java.lang.Math;

// This class is representing a cartesian coordinate in a 2d space with double coordinates.
public class DebugData { // 2. class is not made public -> couldn't be imported
    private double x;
    private double y;

    public DebugData(double x, double y) { // 3. params are listed as ints - shouldve been doubles
        this.x = x;
        this.y = y;
    }

    public double distance(DebugData other) {
        // 5. The method pow(double, double) in the type Math is not applicable for the
        // arguments (double) -> sqrt instead because that's how distance works.
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y; // 4. Shouldve gotten y instead of x.
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String str() {
        return String.format("(%g, %g)", this.x, this.y);
    }
}