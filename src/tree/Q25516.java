package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q25516 {
    static int k;
    static int sum = 0;
    static int[] apples;
    static List<Integer>[] tree;

    static void dfs(int v, int dis) {
        if (dis > k) return;
        sum += apples[v];

        for (int i : tree[v]) {
            dfs(i,  dis + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
        }
        
        apples = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            apples[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        System.out.println(sum);
    }
}

// 71480KB	424ms
