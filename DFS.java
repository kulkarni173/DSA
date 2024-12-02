/* Name:- Sarvesh Kulkarni
  Roll No.:-84
*/

import java.util.LinkedList;
import java.util.Stack;
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

    public void DFS(int s) {
        boolean[] visited = new boolean[numVertices];
        Stack<Integer> S = new Stack<>();

        visited[s] = true;
        S.push(s);

        while (!S.isEmpty()) {
            int currentVertex = S.pop();
            System.out.print(currentVertex + " ");

            for (int i = 0; i < adj[currentVertex].size(); i++) {
                int adjacentVertex = adj[currentVertex].get(i);
                if (!visited[adjacentVertex]) {
                    visited[adjacentVertex] = true;
                    S.push(adjacentVertex);
                }
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int y = sc.nextInt();
        Graph g = new Graph(y);
        System.out.print("Enter the number of edges: ");
        int numEdges = sc.nextInt();

        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge (src dest): ");
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g.addEdge(src, dest);
        }

        g.DFS(0);


    }
}