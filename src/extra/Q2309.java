package extra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2309 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        boolean flag = false;
        int[] height = new int[9];
        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
            sum += height[i];
        }

        int dif = sum - 100;
        for(int i = 0; i < 8 ; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(height[i] + height[j] == dif) {
                    height[i] = 0;
                    height[j] = 0;
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }

        Arrays.sort(height);

        StringBuilder sb = new StringBuilder();
        for(int i = 2; i < 9; i++) {
            sb.append(height[i]).append("\n");
        }
        System.out.print(sb);
    }
}

// 14228KB	100ms
