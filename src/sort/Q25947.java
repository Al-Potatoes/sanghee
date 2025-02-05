package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q25947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int a = Integer.parseInt(line[2]);

        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(price);

        int sum = 0, front = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            sum += price[i] / 2;
            cur++;

            if (cur > a)
                sum += price[front++] / 2;

            if (sum > b) {
                System.out.println(cur-1);
                return;
            }
        }

        System.out.println(n);
    }
}



