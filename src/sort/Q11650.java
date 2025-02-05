package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Q11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (i1, i2) -> {
            if (x[i1] != x[i2])
                return x[i1] - x[i2];
            return y[i1] - y[i2];
        });


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(x[indices[i]]).append(" ").append(y[indices[i]]).append("\n");
        }
        System.out.print(sb);
    }
}
