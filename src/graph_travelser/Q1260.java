package graph_travelser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1260 {
    static boolean[] visitDFS;
    static boolean[] visitBFS;
    static LinkedList<Integer>[] graph;

    public static void dfs(int v) {
        visitDFS[v] = true;
        System.out.print(v + 1 + " ");

        for(int i : graph[v]) {
            if (!visitDFS[i])
                dfs(i);
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visitBFS[v] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            System.out.print(temp + 1 + " ");

            for(int i : graph[temp]) {
                if(!visitBFS[i]) {
                    queue.add(i);
                    visitBFS[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int v = Integer.parseInt(line[2]);

        graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }

        visitDFS = new boolean[n];
        visitBFS = new boolean[n];

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(graph[i]);
        }

        dfs(v - 1);
        System.out.println();
        bfs(v - 1);
    }
}

// 21160KB	276ms
