package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Q25918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] m = br.readLine().toCharArray();

        if (n % 2 == 1) {
            System.out.println("-1");
            return;
        }

        Stack<Character> stack = new Stack<>();

        int max = -1;
        for(char cur : m){
            if(!stack.isEmpty() && stack.peek() != cur)
                stack.pop();
            else
                stack.push(cur);

            max = Math.max(max, stack.size());
        }

        if(stack.isEmpty())
            System.out.println(max);
        else
            System.out.println("-1");
    }
}

// 19532KB  228ms