package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int cur = 1;
        Stack<Integer> tmp = new Stack<>();

        for (int i = 0; i < n; i++) {
            int wait = Integer.parseInt(line[i]);

            while (!tmp.isEmpty() && tmp.peek() == cur) {
                tmp.pop();
                cur++;
            }

            if (wait == cur)
                cur++;
            else
                tmp.push(wait);
        }

        while (!tmp.isEmpty()) {
            if (tmp.pop() != cur) {
                System.out.println("Sad");
                return;
            }
            cur++;
        }

        System.out.println("Nice");
    }
}

// 14320KB	108ms
