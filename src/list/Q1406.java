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

// TODO : Java의 Iterator는 리스트의 "가상의 헤드"에서 시작하여 "가상의 테일"까지 이동
//        가상의 헤드와 테일은 실제 데이터 원소를 가리키지 않고, 원소들 사이를 이동하며 접근을 용이

// TODO : remove는 무조건 next나 previous를 호출한 뒤에 사용되어야 함 -> 해당 반환 값을 삭제
