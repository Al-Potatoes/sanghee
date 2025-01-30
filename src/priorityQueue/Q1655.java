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
            int mid = Integer.parseInt(br.readLine());
            if (i % 2 == 0)
                h.add(mid);
            else
                l.add(mid);

            if (!l.isEmpty() && (h.peek() > l.peek())) {
                h.add(l.poll());
                l.add(h.poll());
            }

            sb.append(h.peek()).append("\n");
        }

        System.out.print(sb);
    }
}
