/*
Name:- Sarvesh Kulkarni
Roll no. 84
 */

import java.util.Scanner;

public class Kruskal_algorithm {
    static int[] parent;
    static final int INF = 999;

    static int find(int i) {
        while (parent[i] != i) {
            i = parent[i];
        }
        return i;
    }

    static void union(int i, int j) {
        int a = find(i);
        int b = find(j);
        parent[a] = b;
    }

    static void kruskalMST(int[][] graph) {
        int v = graph.length;
        parent = new int[v];

        for (int i = 0; i < v; i++) {
            parent[i] = i;
        }

        int minCost = 0;

        int edgeCount = 0;

        while (edgeCount < v - 1) {
            int min = INF;
            int a = -1;
            int b = -1;

            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (find(i) != find(j) && graph[i][j] < min) {
                        min = graph[i][j];
                        a = i;
                        b = j;
                    }
                }
            }

            if (a != -1 && b != -1) {
                union(a, b);
                System.out.println("Edge selected: (" + a + ", " + b + ") weight: " + min);
                minCost += min;
                edgeCount++;
            }
        }

        System.out.println("Minimum cost of the spanning tree: " + minCost);
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

        kruskalMST(graph);

    }
}