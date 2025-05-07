package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char[] word = br.readLine().toCharArray();

            Stack<Character> w = new Stack<>();
            for (int j = 0; j < word.length; j++) {
                if(!w.isEmpty() && word[j] == w.peek()) {
                    w.pop();
                }
                else {
                    w.push(word[j]);
                }
            }

            if(w.isEmpty()) cnt++;
        }

        System.out.println(cnt);
    }
}

// 22156KB	256ms
