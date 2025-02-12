package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2606 {

    static int cnt = 0;
    static boolean[] visited;

    static void rFind(List<Integer>[] graph, int u) {
        if(visited[u]) return;

        cnt++;
        visited[u] = true;

        for (int i : graph[u]) {
            rFind(graph, i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        int e = Integer.parseInt(br.readLine());

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        visited = new boolean[n];

        rFind(graph, 0);

        System.out.println(cnt - 1);
    }
}

// 14304KB	108ms
// TODO : 단방향으로 하면 안 됨 (당연한 소리 ㅋ)