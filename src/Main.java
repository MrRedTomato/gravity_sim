import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 10;
        int fps = 12;

        ArrayList<Mass> objects = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Mass newObject = new Mass(Math.random() * 50, Math.random() * 50, Math.random());
//            objects.add(newObject);
//        }
        objects.add(new Mass(20, 25, 1));
        objects.add(new Mass(30, 25, 1));

        Field field = new Field(objects);
        Display display = new Display(cellSize, fps, field);
    }
}
