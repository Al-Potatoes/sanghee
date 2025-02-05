package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sort = new int[n];
        int[] rank = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sort[i] = arr[i];
        }

        Arrays.sort(sort);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[j] != 0 && sort[i] == arr[j]) {
                    rank[j] = i;
                    arr[j] = 0;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(rank[i]).append(" ");
        }

        System.out.println(sb);
    }
}
