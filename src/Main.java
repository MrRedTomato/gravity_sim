import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 10;
        int fps = 128;

        ArrayList<Mass> objects = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Mass newObject = new Mass(Math.random() * 50, Math.random() * 50, Math.random());
//            objects.add(newObject);
//        }
        objects.add(new Mass(25, 32, 70, 1));
        objects.add(new Mass(35, 37, 70, 1));
        objects.get(0).setXVel(2);
        objects.get(1).setXVel(-2);
        objects.get(0).setYVel(-2);
        objects.get(1).setYVel(2);

        objects.add(new Mass(15, 20, 0.1, 1));
        objects.get(2).setXVel(5);
        objects.get(2).setYVel(-5);
//        objects.get(2).setYVel(-1);

        Field field = new Field(objects);
        field.setStep(0.05);
        Display display = new Display(cellSize, fps, field);
    }
}
