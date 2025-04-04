package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Q1159 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] freq = new int[26];

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            char first = name.charAt(0);
            freq[first - 'a']++;
        }

        ArrayList<Character> player = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] >= 5) {
                player.add((char) (i + 'a'));
            }
        }

        if (player.isEmpty()) {
            System.out.println("PREDAJA");
        }
        else {
            Collections.sort(player);
            StringBuilder sb = new StringBuilder();
            for (char c : player) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}

// 14184KB	104ms
