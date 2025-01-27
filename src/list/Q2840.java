package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2840 {
    static boolean contains(char[] arr, char ch) {
        for (char x : arr) {
            if (x == ch) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        int inx = 0;
        char[] wheel = new char[n];
        Arrays.fill(wheel, '?');

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);


            inx = (inx + s) % n;
            if (wheel[inx] == '?') {
                if(!contains(wheel, ch)) {
                    wheel[inx] = ch;
                }
                else{
                    System.out.println("!");
                    return;
                }
            }
            else if (wheel[inx] != ch) {
                System.out.println("!");
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(wheel[(inx - i + n) % n]);
        }

        System.out.println(sb);
    }
}
