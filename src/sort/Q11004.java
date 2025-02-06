package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11004 {
    static int[] arr;
    static int[] tmp;

    private static void quickSort(int[] arr, int s, int e) {
        if (s >= e)
            return;

        int l = s + 1;
        int h = e;

        while (l <= h) {
            while (l <= e && arr[l] <= arr[s])
                l++;
            while (h > s && arr[h] >= arr[s])
                h--;
            if (l > h)
                swap(arr, h, s);
            else
                swap(arr, l, h);
        }

        quickSort(arr, s, h - 1);
        quickSort(arr, h + 1, e);

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void rMergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            rMergeSort(arr, l, m);
            rMergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int j = m + 1;
        int k = l;

        while (i <= m && j <= r) {
            if (arr[i] <= arr[j])
                tmp[k++] = arr[i++];
            else
                tmp[k++] = arr[j++];
        }

        while (i <= m)
            tmp[k++] = arr[i++];

        while (j <= r)
            tmp[k++] = arr[j++];

        for (k = l; k <= r; k++)
            arr[k] = tmp[k];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);

        arr = new int[n];
        tmp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // quickSort(arr, 0, n-1);
        rMergeSort(arr, 0, n-1);

        System.out.println(arr[k-1]);
    }
}

// TODO : 퀵정렬은 원래 정렬된 배열을 정렬할 시 피벗을 잘못 선택하면 O(n*n)
//  합병 정렬은 항상 O(n log n)
