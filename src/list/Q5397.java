package list;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Q5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char[] pw = br.readLine().toCharArray();

            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iterator = list.listIterator();

            for(char c : pw) {
                switch (c) {
                    case '<':
                        if (iterator.hasPrevious())
                            iterator.previous();
                        break;
                    case '>':
                        if (iterator.hasNext())
                            iterator.next();
                        break;
                    case '-':
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                            iterator.remove();
                        }
                        break;
                    default:
                        iterator.add(c);
                }
            }

            for (char ch : list) {
                sb.append(ch);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
