package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            alpha[name.charAt(i) - 'A']++;
        }

        char tmp = ' ';
        boolean flag = false;

        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 0) {
                sb.append(String.valueOf((char) (i + 'A')).repeat(alpha[i] / 2));
            }
            else if (!flag) {
                tmp = (char) (i + 'A');
                sb.append(String.valueOf((char) (i + 'A')).repeat(alpha[i] / 2));
                flag = true;
            }
            else {
                System.out.println("I'm Sorry Hansoo");
                return;
            }
        }

        StringBuilder res = new StringBuilder().append(sb);
        StringBuilder rev = sb.reverse();

        if (tmp != ' ') {
            res.append(tmp);
        }

        System.out.println(res.append(rev));
    }
}

// 14224KB	100ms
