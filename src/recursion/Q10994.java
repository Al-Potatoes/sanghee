package recursion;

import java.util.Scanner;

public class Q10994 {
    int n;
    StringBuilder sb;

    public void rDrawStar(int k, int i, int j) {
        int min = 2 * k;
        int dif = 4 * n - 4 - min;

        if ((i == min || i == dif || j == min || j == dif)
                && (i >= min && i <= dif && j >= min && j <= dif)) {
            sb.append("*");
            return;
        }

        if (k == n - 1) {
            sb.append(" ");
            return;
        }

        rDrawStar(k + 1, i, j);
    }

    public void solution() throws Exception {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        sb = new StringBuilder();
        for (int i = 0; i < 4 * n - 3; i++) {
            for (int j = 0; j < 4 * n - 3; j++) {
                rDrawStar(0, i, j);
            }
            sb.append('\n');
        }
        System.out.print(sb);

        sc.close();
    }

    public static void main(String[] args) throws Exception {
        new Q10994().solution();
    }
}
