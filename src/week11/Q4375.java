package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line.trim());

            int cnt = 1;
            long num = 1;

            while (num % n != 0) {
                num = (num * 10 + 1) % n;
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}

// 14056KB	100ms
