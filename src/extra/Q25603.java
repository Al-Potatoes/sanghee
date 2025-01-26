package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q25603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                max = Math.max(max, arr[deque.peekFirst()]);
            }
        }

        System.out.println(max);
    }
}
// TODO : 문제 이해를 완전 잘못함
//  -> 선택한 비용의 합이 최소가 되어야 한다고 생각함
//  -> 굳이 그럴 필요 없이 그냥 최댓값만 최소화 하면 되는 것을..
