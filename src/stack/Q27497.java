package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Deque<String> dq = new ArrayDeque<>();
        Stack<Integer> op = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int operator = Integer.parseInt(st.nextToken());

            switch (operator) {
                case 1:
                    dq.offerLast(st.nextToken());
                    op.push(operator);
                    break;
                case 2:
                    dq.offerFirst(st.nextToken());
                    op.push(operator);
                    break;
                case 3:
                    if (!dq.isEmpty()) {
                        if (op.pop() == 1)
                            dq.pollLast();
                        else
                            dq.pollFirst();
                    }
                    break;
            }
        }

        if (dq.isEmpty())
            System.out.println("0");
        else {
            StringBuilder sb = new StringBuilder();
            while (!dq.isEmpty())
                sb.append(dq.pop());
            System.out.println(sb);
        }
    }
}

// TODO : 덱 구현 시 LinkedList VS ArrayDeque
// LinkedList :	269848KB	716ms
// ArrayDeque : 234284KB	668ms

