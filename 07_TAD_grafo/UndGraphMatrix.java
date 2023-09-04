import java.util.Arrays;

public class UndGraphMatrix {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public UndGraphMatrix(int numVertices) {
        this.numVertices = numVertices;
        this.adjacencyMatrix = new int[numVertices][numVertices];
        for (int[] row : adjacencyMatrix) {
            Arrays.fill(row, 0);
        }
    }

    public void addEdge(int from, int to) {
        if (from >= 0 && from < numVertices && to >= 0 && to < numVertices) {
            adjacencyMatrix[from][to] = 1;
            adjacencyMatrix[to][from] = 1; // Since it's an undirected graph
        }
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        UndGraphMatrix graph = new UndGraphMatrix(numVertices);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
