package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q2014 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int k = Integer.parseInt(line[0]);
        int n = Integer.parseInt(line[1]);

        long[] arr = new long[k];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong((st.nextToken()));
            pq.add(arr[i]);
        }

        long num = 0;
        for (int i = 0; i < n; i++) {
            num = pq.poll();

            for (int j = 0; j < k; j++) {
                pq.add(num * arr[j]);

                if (num % arr[j] == 0) {
                    break;
                }
            }
        }

        System.out.println(num);
    }
}
