package q2941;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    int cnt = 0;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ch = br.readLine();

        String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String alpha : croatia) {
            while (ch.contains(alpha)) {
                ch = ch.replace(alpha, "0");
            }
        }

        cnt += ch.length();

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}
