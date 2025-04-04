package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cost = new int[3];
        for (int i = 0; i < 3; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0, min = Integer.MAX_VALUE, max = 0;
        int[] park = new int[101];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = a; j < b; j++) {
                park[j]++;
            }

            min = Math.min(min, a);
            max = Math.max(max, b);
        }

        for (int i = min; i < max; i++) {
            if(park[i] == 3)
                sum += 3 * cost[2];
            else if(park[i] == 2)
                sum += 2 * cost[1];
            else if(park[i] == 1)
                sum += cost[0];
        }

        System.out.println(sum);
    }
}

// 14144KB	100ms
