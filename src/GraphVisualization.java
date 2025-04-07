import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GraphVisualization {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.printMatrix();
        generateGraphVizFile();
    }

    private static void generateGraphVizFile() {
        String graphVizData = "graph G {\n" +
                "    Berlin -- Munich [label="585km"];\n" +
                "    Berlin -- Hamburg [label="255km"];\n" +
                "    Berlin -- Frankfurt [label="555km"];\n" +
                "    Munich -- Stuttgart [label="220km"];\n" +
                "    Hamburg -- Cologne [label="435km"];\n" +
                "    Cologne -- Frankfurt [label="190km"];\n" +
                "    Frankfurt -- Stuttgart [label="200km"];\n" +
                "    Düsseldorf -- Cologne [label="40km"];\n" +
                "    Leipzig -- Berlin [label="150km"];\n" +
                "}";
        try (FileWriter writer = new FileWriter(new File("graph.dot"))) {
            writer.write(graphVizData);
            System.out.println("GraphViz file generated: graph.dot");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
