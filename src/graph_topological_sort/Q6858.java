package graph_topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q6858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 7;
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            graph[i] = new ArrayList<>();

        int[] in = new int[n + 1];

        graph[1].add(7);in[7]++;
        graph[1].add(4);in[4]++;
        graph[2].add(1);in[1]++;
        graph[3].add(4);in[4]++;
        graph[3].add(5);in[5]++;

        while (true) {
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());

            if (x == 0 && y == 0)
                break;

            graph[x].add(y);
            in[y]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) {
                pq.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int cur = pq.poll();
            result.add(cur);

            for (int next : graph[cur]) {
                in[next]--;
                if (in[next] == 0) {
                    pq.offer(next);
                }
            }
        }

        if (result.size() == n) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < result.size(); i++) {
                sb.append(result.get(i));

                if (i != result.size() - 1)
                    sb.append(" ");
            }
            System.out.println(sb);
        }
        else
            System.out.println("Cannot complete these tasks. Going to bed.");

    }
}

// 	14192KB	104ms
