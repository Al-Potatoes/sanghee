package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cars = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cars[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w - 1; i++) {
            bridge.add(0);
        }

        int sec = 0, sum = 0, i = 0;
        while (i < n) {
            if (sum + cars[i] <= l) {
                sum += cars[i];
                bridge.add(cars[i++]);
            }
            else
                bridge.add(0);

            sum -= bridge.poll();

            sec++;
        }

        System.out.println(sec + w);
    }
}

// 14352KB	116ms