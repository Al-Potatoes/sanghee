package q28075;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    int n;
    int m;
    int[] array = new int[6];
    int cnt = 0;

    public void rSpy(int n, int pre, int sum) {
        if (n == 0) {
            if (sum >= m) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < 6; i++) {
            if (Math.abs(i - pre) == 3 || i == pre) {
                rSpy(n - 1, i, sum + array[i] / 2);
            } else {
                rSpy(n - 1, i, sum + array[i]);
            }
        }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        m = Integer.parseInt(firstLine[1]);

        int index = 0;

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                array[index++] = Integer.parseInt(st.nextToken());
            }
        }

        rSpy(n, 100, 0);
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
