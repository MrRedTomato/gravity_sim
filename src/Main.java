import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 5;
        int fps = 64;
        double dt = 0.01;

        // Store the celestial bodies in an array
        ArrayList<Body> bodies = new ArrayList<>();

        //bodies.add(new Body(70, 70, 10000, 2));

        // Create a display, pass in necessary arguments
        // as well as the array of celestial bodies
        Display display = new Display(cellSize, fps, dt, bodies);
    }
}
