package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q32942 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int a = Integer.parseInt(line[0]);
        int b = Integer.parseInt(line[1]);
        int c = Integer.parseInt(line[2]);

        int[][] graph = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (a * (i + 1) + b * (j + 1) == c) {
                    graph[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            Boolean flag = false;

            for (int j = 0; j < 10; j++) {
                if (graph[i][j] == 1) {
                    sb.append(j + 1).append(" ");
                    flag = true;
                }
            }
            if (!flag)
                sb.append("0");

            sb.append("\n");
        }

        System.out.print(sb);
    }
}

// 14208KB	104ms