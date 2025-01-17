package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2447 {
    int n;
    char[][] array;

    public void rDrawStar(int n, int i, int j, char ch) {
        if (n == 1) {
            array[i][j] = ch;
            return;
        }

        n = n / 3;
        rDrawStar(n, i, j, ch);
        rDrawStar(n, i, j + n, ch);
        rDrawStar(n, i, j + 2 * n, ch);
        rDrawStar(n, i + n, j, ch);
        rDrawStar(n, i + n, j + n, ' ');
        rDrawStar(n, i + n, j + 2 * n, ch);
        rDrawStar(n, i + 2 * n, j, ch);
        rDrawStar(n, i + 2 * n, j + n, ch);
        rDrawStar(n, i + 2 * n, j + 2 * n, ch);
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        array = new char[n][n];

        rDrawStar(n, 0, 0, '*');

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(array[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        new Q2447().solution();
    }
}
