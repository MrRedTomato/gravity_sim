import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 8;
        int fps = 64;

        ArrayList<Mass> objects = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Mass newObject = new Mass(Math.random() * 50, Math.random() * 50, Math.random());
//            objects.add(newObject);
//        }
        objects.add(new Mass(25, 20, 0.01, 1.5));
        objects.add(new Mass(50, 35, 100, 2));
        objects.get(0).setXVel(3);
        objects.get(0).setYVel(-2);
//        objects.get(1).setXVel(-0.5);

        Field field = new Field(objects);
        field.setStep(0.05);
        Display display = new Display(cellSize, fps, field);
    }
}
