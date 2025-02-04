package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Q11536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] name = new String[n];
        String[] inc = new String[n];
        String[] dec = new String[n];
        for (int i = 0; i < n; i++) {
            name[i] = br.readLine();
            inc[i] = name[i];
            dec[i] = name[i];
        }

        if (name[0].compareTo(name[1]) < 0) {
            Arrays.sort(inc);
            for (int i = 0; i < n; i++) {
                if (!name[i].equals(inc[i])) {
                    System.out.println("NEITHER");
                    return;
                }
                if (i == n - 1) {
                    System.out.println("INCREASING");
                    return;
                }
            }
        }
        else {
            Arrays.sort(dec, Collections.reverseOrder());
            for (int i = 0; i < n; i++) {
                if (!name[i].equals(dec[i])) {
                    System.out.println("NEITHER");
                    return;
                }
                if (i == n - 1) {
                    System.out.println("DECREASING");
                    return;
                }
            }
        }
    }
}
