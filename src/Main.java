import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 5;
        int fps = 64;
        double dt = 0.01;

        // Store the celestial bodies in an array
        ArrayList<Body> bodies = new ArrayList<>();

        bodies.add(new Body(5, 70, 100, 1));
        bodies.add(new Body(2, 70, 0.1, 0.5));
        bodies.add(new Body(70, 70, 10000, 2));

        bodies.get(0).setVel(new Vector(0, 100));
        bodies.get(1).setVel(new Vector(-30, 145));

        // Create a display, pass in necessary arguments
        // as well as the array of celestial bodies
        Display display = new Display(cellSize, fps, dt, bodies);
    }
}
