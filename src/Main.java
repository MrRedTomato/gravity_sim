import java.util.ArrayList;

public class Main {
    public static void main(String args[]) {
        int cellSize = 10;
        int fps = 24;
        double dt = 0.05;

        // Store the celestial bodies in an array
        ArrayList<Body> bodies = new ArrayList<>();

        bodies.add(new Body(20, 20, 50, 1));
        bodies.add(new Body(40, 40, 50, 1));

//        bodies.get(0).setVel(new Vector(2, 0));
//        bodies.get(1).setVel(new Vector(-2, 0));

        // Create a display, pass in necessary arguments
        // as well as the array of celestial bodies
        Display display = new Display(cellSize, fps, dt, bodies);
    }
}
