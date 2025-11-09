import java.util.ArrayList;

public class Body {
    private Vector position;
    private Vector velocity;
    private Vector acceleration;
    private double mass;
    private double radius;
    private double G = 6.67;

    public Body(double x, double y, double mass, double radius) {
        position = new Vector(x, y);
        this.mass = mass;
        this.radius = radius;
        velocity = new Vector(0, 0);
        acceleration = new Vector(0, 0);
    }
    public Body() {
        position = new Vector(0, 0);
        mass = 0;
        radius = 1;
        velocity = new Vector(0, 0);
        acceleration = new Vector(0, 0);
    }

    public void update(ArrayList<Body> allBodies, double deltaT) {
        double dt = deltaT;

        Vector newAcc = new Vector(0, 0);
        for (Body otherBody : allBodies) {
            if (otherBody != this) {
                Vector r = otherBody.getPosition().sub(this.getPosition());

                if ((r.getMag() - this.getRadius() - otherBody.getRadius()) <= 0.1) {

                    double m1 = this.getMass();
                    double m2 = otherBody.getMass();

                    Vector thisVel = new Vector(this.getVel().mult(((m1 - m2) / (m1 + m2))).add(otherBody.getVel().mult(2 * m2 / (m1 + m2))));
                    Vector otherVel = new Vector(this.getVel().mult(2 * m1 / (m1 + m2)).add(otherBody.getVel().mult((m2 - m1) / (m1 + m2))));

                    this.setVel(thisVel);
                    otherBody.setVel(otherVel);
                }
                Vector otherAcc = r.mult(G * otherBody.getMass() / Math.pow(r.getMag(), 3));

                newAcc = newAcc.add(otherAcc);
            }
        }
        this.setAcc(newAcc);

        this.setVel(this.getVel().add(this.getAcc().mult(dt)));
        this.setPosition(this.getPosition().add(this.getVel().mult(dt)));
    }

    public void setPosition(Vector position) {
        this.position = new Vector(position);
    }
    public Vector getPosition() {
        return new Vector(position.getX(), position.getY());
    }
    public void setVel(Vector velocity) {
        this.velocity = new Vector(velocity);
    }
    public void setAcc(Vector acceleration) {
        this.acceleration = new Vector(acceleration);
    }
    public Vector getVel() {
        return new Vector(velocity.getX(), velocity.getY());
    }
    public Vector getAcc() {
        return new Vector(acceleration.getX(), acceleration.getY());
    }
    public double getMass() {
        return mass;
    }
    public double getRadius() {
        return radius;
    }
}
