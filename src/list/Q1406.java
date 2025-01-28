package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Q1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] string = br.readLine().toCharArray();

        LinkedList<Character> list = new LinkedList<>();
        for (char ch : string) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator(list.size());


        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(0);
            switch (op) {
                case 'L':
                    if (iterator.hasPrevious())
                        iterator.previous();
                    break;
                case 'D':
                    if (iterator.hasNext())
                        iterator.next();
                    break;
                case 'B':
                    if (iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char ch = st.nextToken().charAt(0);
                    iterator.add(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
