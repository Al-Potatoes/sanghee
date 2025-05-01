package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Q9375 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < m; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String b = st.nextToken();

                map.put(b, map.getOrDefault(b, 0) + 1);
            }

            int cnt = 1;
            for (String s : map.keySet()) {
                cnt *= (map.get(s) + 1);
            }

            System.out.println(cnt - 1);
        }
    }
}

// 14128KB	108ms
