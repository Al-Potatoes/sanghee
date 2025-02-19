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

        st = new StringTokenizer(br.readLine());
        Deque<Integer> cars = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            cars.add(Integer.parseInt(st.nextToken()));
        }

        int sec = 0, weight = 0;
        Deque<int[]> bridge = new ArrayDeque<>();
        while (!cars.isEmpty()) {
            int cur = cars.peek();

            if(weight + cur <= l && bridge.size() < w) {
                weight += cur;
                bridge.add(new int[]{cars.poll(), 0});
            }

            for (int[] car : bridge)
                car[1]++;

            if(!bridge.isEmpty() && bridge.peek()[1] == w)
                weight -= bridge.poll()[0];

            sec++;
        }

        System.out.println(sec + w);
    }
}

// 15712KB	128ms
