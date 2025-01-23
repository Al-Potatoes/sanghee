package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1074 {
    static int r, c;
    static int cnt = 0;

    static void rZ(int unit, int i, int j) {
        if (i == r && j == c) {
            System.out.println(cnt);
            return;
        }

        if ((r >= i && r < i + unit) && (c >= j && c < j + unit)) {
            unit /= 2;
            rZ(unit, i, j);
            rZ(unit, i, j + unit);
            rZ(unit, i + unit, j);
            rZ(unit, i + unit, j + unit);
        } else {
            cnt += unit * unit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int num = (int) Math.pow(2, n);
        rZ(num, 0, 0);
    }
}
