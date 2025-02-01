package list;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Q30885 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<long[]> list = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(new long[]{Long.parseLong(st.nextToken()), i + 1});
        }

        while (list.size() > 1) {
            LinkedList<long[]> list2 = new LinkedList<>();
            ListIterator<long[]> iterator = list.listIterator();

            long[] prev = {0, 0};

            while (iterator.hasNext()) {
                long[] curr = iterator.next();
                long size = curr[0];

                if (prev[0] > 0) {
                    if (curr[0] >= prev[0]) {
                        size += prev[0];
                    }
                    else {
                        list2.addLast(prev);
                    }
                }

                if (iterator.hasNext()) {
                    long[] next = iterator.next();

                    if (curr[0] >= next[0]) {
                        size += next[0];
                        iterator.remove();
                    }
                    else {
                        iterator.previous();
                    }
                }

                curr[0] = size;
                prev = curr;
            }

            if (prev[0] > 0)
                list2.add(prev);

            list = list2;
        }

        System.out.println(list.getLast()[0]);
        System.out.println(list.getLast()[1]);
    }
}
