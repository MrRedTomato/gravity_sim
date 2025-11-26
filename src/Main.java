import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 5;
        int fps = 64;
        double dt = 0.01;

        // Store the celestial bodies in an array
        ArrayList<Body> bodies = new ArrayList<>();

        bodies.add(new Body(70, 70, 100, 10, dt));
        bodies.add(new Body(10, 55, 50, 5, dt));

        bodies.get(0).setVel(new Vector(0, 0));
        bodies.get(1).setVel(new Vector(40, 0));

        // Create a display, pass in necessary arguments
        // as well as the array of celestial bodies
        Display display = new Display(cellSize, fps, dt, bodies);
    }
}
