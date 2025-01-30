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

/*

    TODO : 우선순위 큐는 나오는 곳이 한 곳!! -> 첨에 헷갈려서 틀렸었음
    둘의 차이가 1 이상 벌어지면 안 됨
    큐1에는 중앙값보다 작은 값 (우선순위 큐 내림차순)
    큐2에는 중앙값보다 큰 값 (우선순위 큐 오름차순)
    하나씩 일단 차례차례 넣고 그 뒤에 peek 값 비교해서 교체
 */
