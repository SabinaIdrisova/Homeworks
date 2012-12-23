package hw2t1;

public class Main {

    public static void main(String[] args) {
        boolean[][] graph = {
            {false, true, false, false},
            {true, false, true, false},
            {false, true, false, true},
            {false, false, false, true}
        };
        boolean[] robotsInVertices = {false, true, false, true};
        RobotsGraph robots = new RobotsGraph(graph, robotsInVertices);
        if (robots.checkDestroyed()) {
            System.out.println("can be destroyed");
        } else {
            System.out.println("can't be destroyed");
        }
    }
}
