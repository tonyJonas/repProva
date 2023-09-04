import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndGraphList {

    // Classe que representa um vértice
    class Vertex {
        int id;
        List<Vertex> neighbors;

        public Vertex(int id) {
            this.id = id;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(Vertex neighbor) {
            neighbors.add(neighbor);
        }
    }

    private Map<Integer, Vertex> vertices;

    public UndGraphList() {
        vertices = new HashMap<Integer, Vertex>();
    }

    public void addVertex(int id) {
        if (!vertices.containsKey(id)) {
            vertices.put(id, new Vertex(id));
        }
    }

    public void addEdge(int from, int to) {
        if (vertices.containsKey(from) && vertices.containsKey(to)) {
            Vertex v1 = vertices.get(from);
            Vertex v2 = vertices.get(to);
            v1.addNeighbor(v2);
            v2.addNeighbor(v1);
        }
    }

    public void printGraph() {
        for (Vertex vertex : vertices.values()) {
            System.out.print("Vertex " + vertex.id + ": ");
            for (Vertex neighbor : vertex.neighbors) {
                System.out.print(neighbor.id + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        UndGraphList graph = new UndGraphList();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();

    }
}
