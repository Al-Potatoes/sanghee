package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q11725 {
    static int[] res;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    static void findParent(int v) {
        visited[v] = true;

        for (int i : tree[v]) {
            if (!visited[i]) {
                res[i] = v;
                findParent(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        res = new int[n + 1];
        visited = new boolean[n + 1];

        findParent(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= n; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.print(sb);
    }
}

// LinkedList -> ArrayList : 속도 엄청 향상
// 69220KB	504ms
