package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();

        String pat = p.replace("*", ".*");

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String f = br.readLine();

            boolean res = f.matches(pat);
            if (res) {
                sb.append("DA").append("\n");
            }
            else{
                sb.append("NE").append("\n");
            }
        }

        System.out.print(sb);
    }
}

// 14724KB	124ms
