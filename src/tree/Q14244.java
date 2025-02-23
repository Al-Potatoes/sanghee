package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            if (i < n - m + 1)
                sb.append(i).append(" ").append(i + 1).append("\n");
            else
                sb.append(n - m).append(" ").append(i + 1).append("\n");

        }

        System.out.print(sb);
    }
}
