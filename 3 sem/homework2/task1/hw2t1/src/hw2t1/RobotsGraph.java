package hw2t1;

import java.util.LinkedList;
import java.util.Queue;

public class RobotsGraph {
    
    /**
     * constructor for RobotsGraph
     * @param graph the adjacency matrix of the graph
     * @param robotsInVertices matrix showing in which vertices robots exist
     */
    public RobotsGraph(boolean[][] graph, boolean[] robotsInVertices) {
        this.graph = graph;
        this.robotsInVertices = robotsInVertices;
    }
    
    /**
     * Check if all robots in graph can be destroyed
     * @return true, if all robots can be destroyed, false - else
     */
    public boolean checkDestroyed() {
        int robotsAmount = 0;
        for (int i = 0; i < robotsInVertices.length; i++) {
            if (robotsInVertices[i]) {
                robotsAmount++;
            }
        }
        if (robotsAmount == 1) {
            return false;
        }
        boolean[] visitedVertices = new boolean[robotsInVertices.length];
        visitedVertices[0] = true;
        Queue<Integer> listOfVisitedVertices = new LinkedList<Integer>();
        listOfVisitedVertices.add(0);
        int firstGroupAmount = 0;
        if (robotsInVertices[0]) {
            firstGroupAmount++;
        }
        while (!listOfVisitedVertices.isEmpty()) {
            int current = listOfVisitedVertices.remove();
            for (int i = 0; i < graph.length; i++) {
                if (graph[i][current]) {
                    for (int  j = 0; j < graph.length; j++) {
                        if (graph[j][i]) {
                            if (!visitedVertices[j]) {
                                visitedVertices[j] = true;
                                listOfVisitedVertices.add(j);
                                if (robotsInVertices[j]) {
                                    firstGroupAmount++;
                                }
                            }
                        } 
                    }
                }
            }    
        }
        
        if (firstGroupAmount == 1 || robotsAmount - firstGroupAmount == 1) {
            return false;
        }
        return true;  
    }
    
    /**
     * adjacency matrix of graph, shows connections between vertices
     */
    private boolean[][] graph;
    
    /**
     * matrix of vertices, shows in which vertices robots exist
     */
    private boolean[] robotsInVertices;
}
