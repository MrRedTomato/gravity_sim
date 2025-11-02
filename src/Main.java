import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 10;
        int fps = 12;
        Field field = new Field(new ArrayList<Mass>());
        Display display = new Display(cellSize, fps, field);
    }
}
