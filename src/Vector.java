public class Vector {
    private double x, y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Vector(Vector v) {
        x = v.getX();
        y = v.getY();
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
    public Vector sub(Vector v2) {
        return new Vector(this.add(v2.mult(-1)).getX(), this.add(v2.mult(-1)).getY());
    }
    public Vector mult(double scalar) {
        return new Vector(x * scalar, y * scalar);
    }
    public Vector getUnit() {
        return new Vector(this.div(this.getMag()));
    }
    public Vector div(double scalar) {
        return new Vector(x / scalar, y / scalar);
    }
    public double dot(Vector v2) {
        return x * v2.x + y * v2.y;
    }
    public double cross(Vector v2) {
        return x * v2.y - y * v2.x;
    }
    public double getMag() {
        return Math.sqrt(x*x + y*y);
    }

    public String toString() {
        return "<" + x + ", " + y + ">";
    }
}
