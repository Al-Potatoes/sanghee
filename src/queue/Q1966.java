package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int s = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s; i++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);

            Queue<int[]> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(new int[]{x, j});
                pq.offer(x);
            }

            while (!q.isEmpty()) {
                int[] front = q.peek();

                if(front[0] == pq.peek()){
                    q.poll();
                    pq.poll();

                    if(front[1] == m) {
                        sb.append(n - pq.size()).append("\n");
                        break;
                    }
                }
                else{
                    q.offer(q.poll());
                }
            }
        }

        System.out.print(sb);
    }
}

// 	14644KB	124ms