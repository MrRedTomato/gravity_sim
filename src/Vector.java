public class Vector {
    private double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    // Math operations
    public Vector add(Vector v2) {
        return new Vector(x + v2.x, y + v2.y);
    }
    public double dot(Vector v2) {
        return x * v2.x + y * v2.y;
    }
    public Vector cross(Vector v2) {
        return new Vector(x * v2.y, (-2) * y * v2.x);
    }

    public String toString() {
        return "<" + x + ", " + y + ">";
    }
}
