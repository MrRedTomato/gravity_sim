public class Mass {
    private double x, y;
    private double xVel, yVel;
    private double xAcc, yAcc;
    private double mass;
    private double radius;

    public Mass(double x, double y, double mass, double radius) {
        this.x = x;
        this.y = y;
        this.mass = mass;
        this.radius = radius;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }
    public Mass() {
        x = 0;
        y = 0;
        mass = 0;
        radius = 1;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setXVel(double xVel) {
        this.xVel = xVel;
    }
    public void setYVel(double yVel) {
        this.yVel = yVel;
    }
    public void setXAcc(double xAcc) {
        this.xAcc = xAcc;
    }
    public void  setYAcc(double yAcc) {
        this.yAcc = yAcc;
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getXVel() {
        return xVel;
    }
    public double getYVel() {
        return yVel;
    }
    public double getXAcc() {
        return xAcc;
    }
    public double getYAcc() {
        return yAcc;
    }
    public double getMass() {
        return mass;
    }
    public double getRadius() { return radius; }
}
