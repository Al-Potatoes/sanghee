package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] w = br.readLine().toCharArray();

        int flag = 1;
        int s = 0, l = w.length - 1;
        while(s <= l) {
            if(w[s] == w[l]){
                s++;
                l--;
            }
            else {
                flag = 0;
                break;
            }
        }

        System.out.println(flag);
    }
}

// 14188KB	100ms
