package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Q25601 {
    static HashMap<String, ArrayList<String>> tree;

    static boolean rIsCasting(String a, String b) {
        if(tree.get(a) == null)
            return false;

        for (String cur : tree.get(a)) {
            if (cur.equals(b))
                return true;

            if (rIsCasting(cur, b)) // 이 부분을 바보같이 아래 주석처럼 함
                return true;

            // return rIsCasting(cur, b)
            // TODO : 이러면 문제가 return 을 바로 때리니까 다음 자식들을 조사하지 못함.. (당연한 걸)
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        tree = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            String p = st.nextToken();

            if (!tree.containsKey(p)) {
                tree.put(p, new ArrayList<>());
            }

            tree.get(p).add(c);
        }

        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        boolean res1 = rIsCasting(a, b);
        boolean res2 = rIsCasting(b, a);

        if (res1 || res2)
            System.out.println("1");
        else
            System.out.println("0");
    }
}

// 55376KB	500ms
