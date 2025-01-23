package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1780 {
    static int[][] arr;
    static int cnt1 = 0, cnt2 = 0, cnt3 = 0;

    static void rCount(int size, int r, int c) {
        int flag = 0;

        int pre = arr[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (pre != arr[i][j]) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 1){
                break;
            }
        }

        if (flag == 1) {
            int newSize = size / 3;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    rCount(newSize, r + i * newSize, c + j * newSize);
                }
            }
        }
        else
        {
            if (pre == -1) {
                cnt1++;
            } else if (pre == 0) {
                cnt2++;
            } else {
                cnt3++;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rCount(n, 0, 0);

        System.out.println(cnt1 + "\n" + cnt2 + "\n" + cnt3);
    }
}
