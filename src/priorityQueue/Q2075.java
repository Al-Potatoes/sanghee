package priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2075 {
    int n;

    //높은 숫자가 우선
    PriorityQueue<Long> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                priorityQueueHighest.add(Long.valueOf((st.nextToken())));
            }
        }

        for (int i = 0; i < n - 1; i++) {
            priorityQueueHighest.remove();
        }

        System.out.print(priorityQueueHighest.remove());
    }

    public static void main(String[] args) throws Exception {
        new Q2075().solution();
    }
}
