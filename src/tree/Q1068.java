package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1068 {
    static int d;
    static int root = 0;
    static int result = 0;
    static ArrayList<Integer>[] tree;

    static void DFS(int v) {
        if(v == d)
            return;

        int cnt = 0;
        for (int i : tree[v]) {
            if (i != d) {
                cnt++;
                DFS(i);
            }
        }

        if (cnt == 0)
            result++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());

            if (a != -1)
                tree[a].add(i);
            else
                root = i;
        }

        d = Integer.parseInt(br.readLine());

        DFS(root);

        System.out.print(result);
    }
}

// TODO : visitied 를 굳이 안 써도 됨
// 14200KB 	104ms
