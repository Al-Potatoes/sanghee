package recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q18511 {
    int n;
    int k;
    int[] array;
    int result = 0;

    public void rFindMaxNum(int num) {
        if (num > n) {
            return;
        }

        if (num > result) {
            result = num;
        }

        for (int i = k - 1; i >= 0; i--) {
            rFindMaxNum(num * 10 + array[i]);
            }
    }

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        n = Integer.parseInt(firstLine[0]);
        k = Integer.parseInt(firstLine[1]);

        array = new int[k];
        int index = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < k; i++) {
            array[index++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        rFindMaxNum(0);
        System.out.print(result);
    }

    public static void main(String[] args) throws Exception {
        new Q18511().solution();
    }
}
