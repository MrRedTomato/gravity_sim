import java.util.ArrayList;

public class Field {
    private ArrayList<Mass> objects = new ArrayList<>();
    private final double G = 6.67;
    private double step;

    public Field(ArrayList<Mass> objects) {
        this.objects = objects;
        step = 0.1;
    }

    public void addObject(Mass mass) {
        objects.add(mass);
    }

    public ArrayList<Mass> getObjects() {
        return objects;
    }

    public void setStep(double step) {
        this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void update() {
        for (Mass obj : objects) {
            obj.setXVel(obj.getXVel() + obj.getXAcc() * step);
            obj.setYVel(obj.getYVel() + obj.getYAcc() * step);
            obj.setX(obj.getX() + obj.getXVel() * step);
            obj.setY(obj.getY() + obj.getYVel() * step);
        }

        for (Mass obj : objects) {
            double accX, accY;
            accX = 0;
            accY = 0;
            for (Mass otherObj : objects) {
                if (obj != otherObj) {
                    double deltaX = otherObj.getX() - obj.getX();
                    double deltaY = otherObj.getY() - obj.getY();
                    double rSquare = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);

                    double cosTheta = deltaX / Math.sqrt(rSquare);
                    double sinTheta = deltaY / Math.sqrt(rSquare);
                    double m2 = otherObj.getMass();

                    accX += G * m2 * cosTheta / rSquare;
                    accY += G * m2 * sinTheta / rSquare;
                }
            }
            System.out.println(objects.indexOf(obj) + ": accX = " + accX + ", accY = " + accY);
            obj.setXAcc(accX);
            obj.setYAcc(accY);
        }
    }
}
