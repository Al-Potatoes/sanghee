package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1068 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int root = 0;
    static int result = 0;

    static void DFS(int v) {
        visited[v] = true;

        int cnt = 0;
        for (int i : graph[v]) {
            if (!visited[i]) {
                cnt++;
                DFS(i);
            }
        }

        if (cnt == 0)
            result++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (a != -1) {
                graph[i].add(a);
                graph[a].add(i);
            }
            else
                root = i;
        }

        int d = Integer.parseInt(br.readLine());
        visited[d] = true;

        DFS(root);

        if (root != d)
            System.out.print(result);
        else
            System.out.print(0);
    }
}

// TODO : visited 의 역할 !!
// 14200KB 	104ms
