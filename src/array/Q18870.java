package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

public class Q18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        int[] sorted = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sorted[i] = arr[i];
        }

        sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int cnt = 0;
        for(int i = 0; i<n; i++){
            if(!map.containsKey(sorted[i])) {
                map.put(sorted[i], cnt++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb);
    }
}
