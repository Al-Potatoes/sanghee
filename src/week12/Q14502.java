package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14502 {

    static int n, m, min = 64;

    static ArrayList<Integer> viruses = new ArrayList<>();
    static ArrayList<Integer> empty = new ArrayList<>();

    static int[] d;
    static int[] safe;
    static boolean[] visited;

    static int dfs(int v) {
        if (visited[v]) return 0;

        visited[v] = true;

        int size = 1;
        for (int i = 0; i < 4; i++) {
            if (v % m == 0 && i == 2) continue;
            if (v % m == m - 1 && i == 3) continue;

            int idx = v + d[i];
            if (idx >= 0 && idx < safe.length) {
                if(safe[idx] != 1 && !visited[idx]) {
                    size += dfs(idx);
                }
            }
        }

        return size;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int[]{-m, m, -1, 1};
        safe = new int[n * m];

        int idx = 0;
        int wall = 3;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(st.nextToken());

                if (input == 1) wall++;
                else if (input == 2) viruses.add(idx);
                else if (input == 0) empty.add(idx);

                safe[idx++] = input;
            }
        }

        for (int w1 = 0; w1 < empty.size(); w1++) {
            for (int w2 = w1 + 1; w2 < empty.size(); w2++) {
                for (int w3 = w2 + 1; w3 < empty.size(); w3++) {
                    int p1 = empty.get(w1);
                    int p2 = empty.get(w2);
                    int p3 = empty.get(w3);

                    safe[p1] = 1;
                    safe[p2] = 1;
                    safe[p3] = 1;

                    visited = new boolean[n * m];

                    int size = wall;
                    for (int v : viruses) {
                        size += dfs(v);
                    }

                    min = Math.min(min, size);

                    safe[p1] = 0;
                    safe[p2] = 0;
                    safe[p3] = 0;
                }
            }
        }

        System.out.println(n * m - min);
    }
}

// 21208KB	248ms
/* TODO : 리팩터링 전 - 3개의 벽을 선택할 때 모든 배열 인덱스를 다 검사 (약간 버블 정렬 느낌의 for 문)
          리팩터링 후 - 0으로 채워진 빈 공간의 인덱스를 리스트에 넣고 for 문을 돌릴 때 (약간 선택 정렬 느낌의 for 문)
                     w2는 w1 + 1 차례의 인덱스, w3은 w2 + 1 차례의 인덱스 값부터 검사
 */
