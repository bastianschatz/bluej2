import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<String, Integer> cities;
    private int[][] adjacencyMatrix;

    public Graph() {
        initializeCities();
        initializeAdjacencyMatrix();
    }

    private void initializeCities() {
        cities = new HashMap<>();
        String[] cityNames = { "Berlin", "Munich", "Hamburg", "Cologne", "Frankfurt", "Stuttgart", "Düsseldorf", "Leipzig" };
        for (int i = 0; i < cityNames.length; i++) {
            cities.put(cityNames[i], i);
        }
    }

    private void initializeAdjacencyMatrix() {
        int size = cities.size();
        adjacencyMatrix = new int[size][size];

        // Fill adjacency matrix with distances in km
        addDistance("Berlin", "Munich", 585);
        addDistance("Berlin", "Hamburg", 255);
        addDistance("Berlin", "Frankfurt", 555);
        addDistance("Munich", "Stuttgart", 220);
        addDistance("Hamburg", "Cologne", 435);
        addDistance("Cologne", "Frankfurt", 190);
        addDistance("Frankfurt", "Stuttgart", 200);
        addDistance("Düsseldorf", "Cologne", 40);
        addDistance("Leipzig", "Berlin", 150);
    }

    private void addDistance(String city1, String city2, int distance) {
        int idx1 = cities.get(city1);
        int idx2 = cities.get(city2);
        adjacencyMatrix[idx1][idx2] = distance;
        adjacencyMatrix[idx2][idx1] = distance;
    }

    public void printMatrix() {
        System.out.println("Adjacency Matrix:");
        for (int[] row : adjacencyMatrix) {
            for (int dist : row) {
                System.out.print((dist == 0 ? "-" : dist) + " ");
            }
            System.out.println();
        }
    }
}
