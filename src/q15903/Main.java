package q15903;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    int n;
    int m;
    Long sum = 0L;

    //낮은 숫자가 우선
    PriorityQueue<Long> priorityQueueLowest = new PriorityQueue<>();

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            priorityQueueLowest.add(Long.valueOf(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            Long x = priorityQueueLowest.remove();
            Long y = priorityQueueLowest.remove();

            priorityQueueLowest.add(x + y);
            priorityQueueLowest.add(x + y);
        }

        for (int i = 0; i < n; i++) {
            sum += priorityQueueLowest.remove();
        }

        System.out.print(sum);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
