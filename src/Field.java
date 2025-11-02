import java.util.ArrayList;

public class Field {
    ArrayList<Mass> objects = new ArrayList<>();
    final double G = 6.67;

    public Field(ArrayList<Mass> objects) {
        this.objects = objects;
    }

    public void addObject(Mass mass) {
        objects.add(mass);
    }

    public ArrayList<Mass> getObjects() {
        return objects;
    }

    public void update() {
        ArrayList<Mass> newObjects = new ArrayList<>();
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
        System.out.println();

        for (Mass obj : objects) {
            obj.setXVel(obj.getXVel() + obj.getXAcc());
            obj.setYVel(obj.getYVel() + obj.getYAcc());
            obj.setX(obj.getX() + obj.getXVel());
            obj.setY(obj.getY() + obj.getYVel());
        }
    }
}
