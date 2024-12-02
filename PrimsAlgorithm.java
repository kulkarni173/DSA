/* Name:- Sarvesh Kulkarni
  Roll No.:-84
*/

import java.util.*;

public class PrimsAlgorithm {

    public void prim(int G[][], int v) {
        int mincost = 0;
        int INF = 999;
        int no_edge = 0;

        boolean[] select = new boolean[v];
        Arrays.fill(select,false);
        select[0] = true;

        while (no_edge < v-1) {
            int min = INF;
            int x = 0;
            int y = 0;

            for (int i = 0; i < v; i++) {
                if (select[i]) {
                    for (int j = 0; j < v; j++) {
                        if (!select[j] && G[i][j] < min) {
                            min = G[i][j];
                            x = i;
                            y = j;
                        }
                    }
                }
            }

            if (min != INF) {
                System.out.println("Edge selected: (" + x + ", " + y + ") weight: " + min);
                mincost += min;
                select[y] = true;
                no_edge++;
            }
        }
        System.out.println("Minimum cost : " + mincost);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the number of vertices:");
        int v = s.nextInt();
        int[][] G = new int[v][v];

        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                G[i][j] = s.nextInt();
            }
        }

        PrimsAlgorithm obj = new PrimsAlgorithm();
        obj.prim(G,v);
    }
}