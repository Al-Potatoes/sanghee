package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Q5464 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[] cost = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cost[i] = Integer.parseInt(br.readLine());
        }

        int[] car = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            car[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;
        int[] parked = new int[n + 1];
        Deque<Integer> wait = new ArrayDeque<>();

        for (int i = 0; i < 2 * m; i++) {
            int park = Integer.parseInt(br.readLine());

            if (park > 0) {
                boolean flag = false;

                for (int j = 1; j <= n; j++) {
                    if (parked[j] == 0) {
                        flag = true;
                        parked[j] = park;
                        break;
                    }
                }

                if (!flag)
                    wait.add(park);
            }
            else {
                park *= -1;

                for (int j = 1; j <= n; j++) {
                    if (parked[j] == park) {
                        res += car[parked[j]] * cost[j];
                        parked[j] = 0;

                        if (!wait.isEmpty())
                            parked[j] = wait.poll();
                    }
                }
            }
        }

        System.out.println(res);
    }
}

// 15188KB	124ms