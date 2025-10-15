import java.util.Scanner;

public class DFS {
    private int[][] adjacencyMatrix;
    private int numVertices;

    public DFS(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = 1;
            adjacencyMatrix[j][i] = 1; // Remove for directed graph
        }
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[numVertices];
        System.out.print("DFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfsHelper(i, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices: ");
        int n = sc.nextInt();

        DFS graph = new DFS(n);

        System.out.print("Enter number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter edges (u v): ");
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }

        System.out.print("Enter starting vertex for DFS: ");
        int start = sc.nextInt();
        graph.dfs(start);
        sc.close();
    }
}
