package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] s = new int[n];
        int[] e = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            e[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] inx = new Integer[n];
        for (int i = 0; i < n; i++) {
            inx[i] = i;
        }

        Arrays.sort(inx, (i1, i2) -> {
            if (e[i1] != e[i2])
                return e[i1] - e[i2];
            return s[i1] - s[i2];
        });

        int cnt = 1;
        int last = e[inx[0]];
        for (int i = 1; i < n; i++) {
            if (last <= s[inx[i]]) {
                cnt++;
                last = e[inx[i]];
            }
        }

        System.out.println(cnt);
    }
}

// TODO : 문제를 잘 읽자 ^^ -> 회의의 시작시간과 끝나는 시간이 같을 수도 있다.
// 근데 누가 회의를 시작하자마자 끝내는데;;
