package recursion;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q11582 {
    int n;
    int k;
    int[] arr;

    public void rMergeSort(int i, int s, int e) {
        if (i == n/k) {
            Arrays.sort(arr,s,e+1);
            return;
        }

        i /= 2;
        rMergeSort(i, s, s + i - 1);
        rMergeSort(i, s + i, e);
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }

        k = sc.nextInt();

        rMergeSort(n, 0, n-1);

        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) {
        new Q11582().solution();
    }
}
