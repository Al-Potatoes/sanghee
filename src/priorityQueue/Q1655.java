package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Q1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> l = new PriorityQueue<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i % 2 == 0)
                h.add(num);
            else
                l.add(num);

            if(i == 0) {
                sb.append(h.peek());
            }
            else {
                int max = h.poll();
                int min = l.poll();
                h.add(min);
                l.add(max);

                if (l.peek() < h.peek())
                    sb.append(l.peek());
                else
                    sb.append(h.peek());
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}
