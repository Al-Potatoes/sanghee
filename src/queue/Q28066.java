package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q28066 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() >= k) {
            q.add(q.poll());

            for (int i = 0; i < k - 1; i++) {
                q.poll();
            }
        }

        System.out.println(q.poll());
    }
}

// 44780KB	184ms
// TODO : split 이랑 StringTokenizer 차이 40ms ㄷㄷ;