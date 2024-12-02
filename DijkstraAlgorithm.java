/* Name:- Sarvesh Kulkarni
  Roll No.:-84
*/

import java.util.Scanner;

public class DijkstraAlgorithm {
    static final int INF = 999;

    static void dijkstra(int graph[][], int src, int v) {
        int[] dist = new int[v];
        boolean[] visited = new boolean[v];

        for (int i = 0; i < v; i++) {
            dist[i] = INF;
            visited[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < v - 1; count++) {
            int u = minDistance(dist, visited, v);
            visited[u] = true;

            for (int w = 0; w < v; w++) {
                if (!visited[w] && graph[u][w] != 0 && dist[u] != INF && dist[u] + graph[u][w] < dist[w]) {
                    dist[w] = dist[u] + graph[u][w];
                }
            }
        }

        printSolution(dist, v);
    }

    static int minDistance(int[] dist, boolean[] visited, int v) {
        int min = INF, minIndex = -1;

        for (int i = 0; i < v; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void printSolution(int[] dist, int v) {
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < v; i++) {
            System.out.println("to " + i + " the shortest distance is: " + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int v = s.nextInt();
        int[][] graph = new int[v][v];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph[i][j] = s.nextInt();
            }
        }

        System.out.println("Enter the source vertex (0 to " + (v - 1) + "):");
        int src = s.nextInt();

        dijkstra(graph, src, v);


    }
}