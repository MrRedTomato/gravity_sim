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
            Mass newObject = new Mass();
            for (int j = 0; j < objects.size(); j++) {
                if (j != i) {
                    double deltaX = objects.get(i).getX() - objects.get(j).getX();
                    double deltaY = objects.get(i).getY() - objects.get(j).getY();
                    double rSquare = Math.pow(deltaX, 2) + Math.pow(deltaY, 2);
//                    double cosTheta = Math.
                }
            }
        }
    }
}
