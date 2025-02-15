package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        int num = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                num *= 2;
                stack.push(cur);
            }
            else if (cur == '[') {
                num *= 3;
                stack.push(cur);
            }
            else if (cur == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    System.out.println(0);
                    return;
                }

                if (input.charAt(i - 1) == '(') {
                    result += num;
                }

                num /= 2;
                stack.pop();
            }
            else if (cur == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    System.out.println(0);
                    return;
                }

                if (input.charAt(i - 1) == '[') {
                    result += num;
                }

                num /= 3;
                stack.pop();
            }
        }

        if (!stack.isEmpty())
            System.out.println(0);
        else
            System.out.println(result);
    }
}

// 14284KB	104ms
