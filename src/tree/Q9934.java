package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9934 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int n = (int) Math.pow(2, k);

        int[] tree = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n - 1; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int j = n;
        int unit = n;
        for (int i = 1; i <= k; i++) {
            j = j / 2;

            int l = j;
            while (l <= n - 1) {
                sb.append(tree[l]).append(" ");

                l += unit;
            }

            unit = unit / 2;
            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// TODO : 레전드.. 계속 %를 나누기로 생각해서..
// 14256KB	112ms
