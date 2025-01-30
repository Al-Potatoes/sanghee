package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            PriorityQueue<Long> h = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Long> l = new PriorityQueue<>();

            int m = Integer.parseInt(br.readLine());
            sb.append((m + 1) / 2).append("\n");

            int unit = m > 9 ? m / 10 + 1 : 1;
            for (int s = 0; s < unit; s++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; st.hasMoreTokens(); j++) {
                    long mid = Long.parseLong(st.nextToken());
                    if (j % 2 == 0)
                        h.add(mid);
                    else
                        l.add(mid);

                    if (!l.isEmpty() && (h.peek() > l.peek())) {
                        h.add(l.poll());
                        l.add(h.poll());
                    }

                    if (j % 2 == 0)
                        sb.append(h.peek()).append(" ");
                }

                if (s % 2 == 1 || unit == 1)
                    sb.append("\n");
            }
        }

        System.out.print(sb);
    }
}
