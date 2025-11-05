public class Mass {
    private Point position;
    private double xVel, yVel;
    private double xAcc, yAcc;
    private double mass;
    private double radius;

    public Mass(double x, double y, double mass, double radius) {
        position = new Point(x, y);
        this.mass = mass;
        this.radius = radius;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }
    public Mass() {
        position = new Point(0, 0);
        mass = 0;
        radius = 1;
        xVel = 0;
        yVel = 0;
        xAcc = 0;
        yAcc = 0;
    }

    public void setX(double x) {
        position.x = x;
    }
    public void setY(double y) {
        position.y = y;
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
        return position.x;
    }
    public double getY() {
        return position.y;
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
