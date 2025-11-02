import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 8;
        int fps = 12;

        ArrayList<Mass> objects = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Mass newObject = new Mass(Math.random() * 50, Math.random() * 50, Math.random());
//            objects.add(newObject);
//        }
        objects.add(new Mass(10, 20, 0.01, 1.5));
        objects.add(new Mass(50, 35, 100, 1.5));
        objects.get(0).setXVel(2);
        objects.get(0).setYVel(-2);
//        objects.get(1).setXVel(-0.5);

        Field field = new Field(objects);
        Display display = new Display(cellSize, fps, field);
    }
}
