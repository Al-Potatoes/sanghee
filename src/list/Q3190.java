package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] apple = new int[n][n];

        StringTokenizer st;
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r - 1][c - 1] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0, 0});
        
        int x = 0;
        char c = ' ';
        int dir = 0, row = 0, col = 0, t = 0;
        for (int i = 0; i < l + 1; i++) {
            if (i != l) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                c = st.nextToken().charAt(0);
            }

            while (true) {
                t++;
                switch (dir % 360) {
                    case 0: col++; break;
                    case 90: row--; break;
                    case 180: col--; break;
                    case 270: row++; break;
                }

                if (row < 0 || row >= n || col < 0 || col >= n) {
                    System.out.println(t);
                    return;
                }

                for (int[] arr : list) {
                    if (Arrays.equals(arr, new int[]{row, col})) {
                        System.out.println(t);
                        return;
                    }
                }

                list.add(new int[]{row, col});

                if (apple[row][col] == 0)
                    list.removeFirst();
                else
                    apple[row][col] = 0;

                if (i != l && t == x) break;
            }

            if (c == 'D')  dir = (dir - 90 + 360) % 360;
            if (c == 'L')  dir = (dir + 90 + 360) % 360;
        }
    }
}

// TODO : 먹은 사과 처리.. 먹었으면 먹었다고 표시를 해야지..

//            90(위) 0(오) 270(아래) 180(왼)

//                    90
//                180     0 = 360
//                    270
