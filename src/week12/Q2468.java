package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2468 {

    static int[][] area;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};


    static void dfs(int i, int j, int rain) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x >= 0 && y >= 0 && x < area.length && y < area[0].length) {
                if (area[x][y] > rain && !visited[x][y]) {
                    dfs(x, y,rain);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int max = 0;
        area = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, area[i][j]);
            }
        }


        int res = 1;
        for (int rain = 0; rain <= max; rain++) {
            visited = new boolean[n][n];

            int safe = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (area[i][j] > rain && !visited[i][j]) {
                        dfs(i, j, rain);
                        safe++;
                    }
                }
            }

            res = Math.max(res, safe);
        }

        System.out.println(res);
    }
}

// 19048KB	228ms
