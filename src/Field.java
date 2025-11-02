import java.util.ArrayList;

public class Field {
    ArrayList<Mass> objects = new ArrayList<>();
    final double G = 6.6743;

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
        for (int i = 0; i < objects.size(); i++) {
            Mass newObject = new Mass(objects.get(i).getX() + objects.get(i).getXVel(), objects.get(i).getY() + objects.get(i).getYAcc(), objects.get(i).getMass());
            newObject.setXVel(objects.get(i).getXVel() + objects.get(i).getXAcc());
            newObject.setYVel(objects.get(i).getYVel() + objects.get(i).getYAcc());
            newObject.setXAcc(objects.get(i).getXAcc());
            newObject.setYAcc(objects.get(i).getYAcc());
            for (int j = 0; j < objects.size(); j++) {
                if (j != i) {
                    double deltaX = objects.get(i).getX() - objects.get(j).getX();
                    double deltaY = objects.get(i).getY() - objects.get(j).getY();
                    double rSquare = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
                    double cosTheta = deltaX / Math.sqrt(rSquare);
                    double sinTheta = deltaY / Math.sqrt(rSquare);
                    double m2 = objects.get(j).getMass();

                    double accX = G * m2 * cosTheta / rSquare;
                    double accY = G * m2 * sinTheta / rSquare;
                    newObject.setXAcc(newObject.getXAcc() + accX);
                    newObject.setYAcc(newObject.getYAcc() + accY);
                }
            }
            newObjects.add(newObject);
        }
        objects = newObjects;
    }
}
