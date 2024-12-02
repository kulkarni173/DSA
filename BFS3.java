/* Name:- Sarvesh Kulkarni
  Roll No.:-84
*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.numVertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adj[src].add(dest);

    }

    public void BFS(int s) {
        boolean[] visited = new boolean[numVertices];
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int currentVertex = q.remove();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < adj[currentVertex].size(); i++) {
                int adjacentVertex = adj[currentVertex].get(i);
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    q.add(adjacentVertex);
                }
            }
        }
    }
}

public class BFS3 {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int y = S.nextInt();
        Graph g = new Graph(y);
        System.out.print("Enter the number of edges: ");
        int numEdges = S.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge (src dest): ");
            int src = S.nextInt();
            int dest = S.nextInt();
            g.addEdge(src, dest);
        }

        g.BFS(0);


    }
}