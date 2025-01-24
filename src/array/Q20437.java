package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q20437 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            char[] ch = br.readLine().toCharArray();
            int k = Integer.parseInt(br.readLine());

            int[] cnt = new int[26];
            for (int j = 0; j < ch.length; j++) {
                cnt[ch[j] - 'a']++;
            }

            int min = Integer.MAX_VALUE, max = -1;
            for (int s = 0; s < ch.length; s++) {
                if (cnt[ch[s] - 'a'] < k) {
                    continue;
                }

                int count = 0;
                for (int l = s; l < ch.length; l++) {
                    if (ch[s] == ch[l]) {
                        count++;
                    }
                    if (count == k) {
                        min = Math.min(min, (l - s + 1));
                        max = Math.max(max, (l - s + 1));
                        break;
                    }
                }
            }

            if (min != Integer.MAX_VALUE && max != -1) {
                sb.append(min).append(" ").append(max).append("\n");
            }
            else {
                sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
