package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14502 {

    static int n, m, min = 64;
    static int[] safe;
    static boolean[] visited;

    // static int[] d = {-m, +m, -1, +1};
    /* TODO : 정적 배열 초기화 방식에 변수값을 넣으면 안 됨
              Java에서 배열 선언 시 -m이나 +m은 컴파일 타임 상수이어야 함
              m이 static final이 아닌 일반 변수일 경우, Java는 -m을 상수로 간주하지 못함
              그래서 실행 시 원하는 값이 안 들어감
     */

    static int[] d; // 상하좌우

    static int dfs(int v) {
        if(visited[v]) return 0;

        visited[v] = true;
        int size = 1;

        for (int i = 0; i < 4; i++) {
            if (v % m == 0 && i == 2) continue;  // 가장 왼쪽 열이면 좌측 검사 패스
            if (v % m == m - 1 && i == 3) continue; // 가장 오른쪽 열이면 우측 검사 패스

            int idx = v + d[i];

            if (idx >= 0 && idx < safe.length) {
                if (safe[idx] != 1 && !visited[idx]) {
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
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                safe[idx++] = Integer.parseInt(st.nextToken());
            }
        }

        for (int w1 = 0; w1 < n * m; w1++) {
            // 벽을 세울 수 없으면
            if (safe[w1] != 0) continue;

            for (int w2 = 0; w2 < n * m; w2++) {
                // 벽2가 벽1과 위치가 같거나 벽을 세울 수 없으면
                if (w2 == w1 || safe[w2] != 0) continue;

                for (int w3 = 0; w3 < n * m; w3++) {
                    // 벽3이 벽1 또는 벽2와 위치가 같거나 벽을 세울 수 없으면
                    if (w3 == w1 || w3 == w2 || safe[w3] != 0) continue;

                    safe[w1] = 1;
                    safe[w2] = 1;
                    safe[w3] = 1;

                    int size = 0;
                    visited = new boolean[n * m];
                    for(int i = 0; i < n * m; i++) {
                        if(safe[i] == 2) {
                            size += dfs(i);
                        }
                        else if(safe[i] == 1) {
                            size ++;
                        }
                    }

                    min = Math.min(min, size);

                    // 다시 원 상태로
                    safe[w1] = 0;
                    safe[w2] = 0;
                    safe[w3] = 0;
                }
            }
        }

        System.out.println(n * m - min);
    }
}

// 	33780KB	660ms
