import java.util.*;

public class DijkstraOSPF {

    public static int[] dijkstra(int[][] g, int src) {
        int n = g.length;
        int[] dist = new int[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int i = 0; i < n; i++) {

            int u = -1;
            for (int v = 0; v < n; v++)
                if (!vis[v] && (u == -1 || dist[v] < dist[u]))
                    u = v;

            vis[u] = true;

            for (int v = 0; v < n; v++)
                if (g[u][v] > 0 && dist[u] + g[u][v] < dist[v])
                    dist[v] = dist[u] + g[u][v];
        }
        return dist;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {0, 4, 0, 0, 8, 0},
            {4, 0, 2, 0, 0, 0},
            {0, 2, 0, 3, 0, 0},
            {0, 0, 3, 0, 0, 7},
            {8, 0, 0, 0, 0, 5},
            {0, 0, 0, 7, 5, 0}
        };

        int[] dist = dijkstra(graph, 0);

        System.out.println("Shortest distances from Router 0:");
        for (int i = 0; i < dist.length; i++)
            System.out.println("To Router " + i + " = " + dist[i]);
    }
}
