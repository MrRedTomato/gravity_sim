import java.util.ArrayList;

public class Body {
    private Vector position;
    private Vector velocity;
    private Vector acceleration;
    private double mass;
    private double radius;
    private double G = 6.67e1;
    private double dt;

    public Body(double x, double y, double mass, double radius, double dt) {
        position = new Vector(x, y);
        this.mass = mass;
        this.radius = radius;
        this.dt = dt;
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

    public void update(ArrayList<Body> allBodies) {
        Vector newAcc = new Vector(0, 0);
        for (Body otherBody : allBodies) {
            if (otherBody != this) {
                Vector r = otherBody.getPosition().sub(this.getPosition());
                Vector relativeV = otherBody.getVel().sub(this.getVel());

                double rDotV = r.dot(relativeV);

                if ((r.getMag() - this.getRadius() - otherBody.getRadius()) <= 0.1 && rDotV <= 0) {
                    double m1 = this.getMass();
                    double m2 = otherBody.getMass();

                    /*
                    Idea: split the initial velocities into parallel and perpendicular to r. Collide the parallel components in 1-D. Recombine with perpendicular components to get final velocities.

                    r = pos2 - pos1
                    m1 * v1_i + m2 * v2_i = m1 * v1_f + m2 * v2_f
                    v1_f - v1_i = k_1 * r
                    v2_f - v2_i = k_2 * r

                    double thisVelPar = this.getVel().dot(r);
                    double otherVelPar = otherBody.getVel().dot(r);

                    Vector thisResVelPar = new Vector(thisVelPar.mult(((m1 - m2) / (m1 + m2))).add(otherVelPar.mult(2 * m2 / (m1 + m2))));
                    Vector otherResVelPar = new Vector(thisVelPar.mult(2 * m1 / (m1 + m2)).add(otherVelPar.mult((m2 - m1) / (m1 + m2))));
                    */



                    Vector thisVel = new Vector(this.getVel().sub(this.getPosition().sub(otherBody.getPosition()).mult((2 * m2) / (m1 + m2) * this.getVel().sub(otherBody.getVel()).dot(this.getPosition().sub(otherBody.getPosition())) / Math.pow(this.getPosition().sub(otherBody.getPosition()).getMag(), 2))));
                    Vector otherVel = new Vector(otherBody.getVel().sub(otherBody.getPosition().sub(this.getPosition()).mult((2 * m1) / (m1 + m2) * otherBody.getVel().sub(this.getVel()).dot(otherBody.getPosition().sub(this.getPosition())) / Math.pow(otherBody.getPosition().sub(this.getPosition()).getMag(), 2))));

                    this.setVel(thisVel);
                    otherBody.setVel(otherVel);
                }
                else {
                    Vector otherAcc = r.mult(G * otherBody.getMass() / Math.pow(r.getMag(), 3));

                    newAcc = newAcc.add(otherAcc);
                }
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
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setMass(double mass) {
        this.mass = mass;
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
