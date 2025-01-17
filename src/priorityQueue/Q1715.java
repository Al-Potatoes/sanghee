package priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1715 {
    int n;
    Long sum = 0L;

    PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            priorityQueue.add(Long.valueOf(st.nextToken()));
        }

        while (priorityQueue.size() != 1) {
            Long a = priorityQueue.remove();
            Long b = priorityQueue.remove();

            sum += a + b;
            priorityQueue.add(a + b);
        }

        System.out.println(sum);
    }

    public static void main(String[] args) throws Exception {
        new Q1715().solution();
    }
}




