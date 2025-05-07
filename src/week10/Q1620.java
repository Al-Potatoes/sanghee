package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String p = br.readLine();
            name.put(p, i + 1);
            idx.put(i + 1, p);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            String in = st.nextToken();
            if(Character.isDigit(in.charAt(0))) {
                sb.append(idx.get(Integer.parseInt(in))).append("\n");
            }
            else {
                sb.append(name.get(in)).append("\n");
            }
        }

        System.out.print(sb);
    }
}

// 60640KB	528ms
