import java.util.LinkedList;
public class Main {



    // ! WAY 1 - REPRESTING GRAPH USING ADJACENCY LIST
    public static class GraphAdjMatrix {
        private int[][] adjMatrix;
        private int numVertices;

        public GraphAdjMatrix(int numVertices) {
            this.numVertices = numVertices;
            adjMatrix = new int[numVertices][numVertices];
        }

        public void addEdge(int i, int j) {
            adjMatrix[i][j] = 1;
            adjMatrix[j][i] = 1; // For undirected graph
        }

        public void removeEdge(int i, int j) {
            adjMatrix[i][j] = 0;
            adjMatrix[j][i] = 0; // For undirected graph
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    System.out.print(adjMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            GraphAdjMatrix graph = new GraphAdjMatrix(4);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);

            graph.printGraph();
        }
    }


    // ! WAY 2 - REPRESTING GRAPH USING ADJACENCY LIST


    public static class GraphAdjList {
        private LinkedList<Integer>[] adjList;
        private int numVertices;

        public GraphAdjList(int numVertices) {
            this.numVertices = numVertices;
            adjList = new LinkedList[numVertices];
            for (int i = 0; i < numVertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src); // For undirected graph
        }

        public void removeEdge(int src, int dest) {
            adjList[src].remove((Integer) dest);
            adjList[dest].remove((Integer) src); // For undirected graph
        }

        public void printGraph() {
            for (int i = 0; i < numVertices; i++) {
                System.out.print("Vertex " + i + ":");
                for (Integer vertex : adjList[i]) {
                    System.out.print(" -> " + vertex);
                }
                System.out.println();
            }
        }

        public static void main(String[] args) {
            GraphAdjList graph = new GraphAdjList(4);
            graph.addEdge(0, 1);
            graph.addEdge(0, 2);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);

            graph.printGraph();
        }
    }

}