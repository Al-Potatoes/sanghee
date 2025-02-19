package graph_travelser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q14218 {
    static int n, m;
    static List<Integer>[] graph;

    public static int[] bfs() {
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int v : graph[cur]) {
                if (dis[v] == -1) {
                    dis[v] = dis[cur] + 1;
                    queue.add(v);
                }
            }
        }

        return dis;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);

            int[] dis = bfs();

            for (int j = 0; j < n; j++) {
                sb.append(dis[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// 35112KB	636ms