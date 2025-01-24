package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1629 {
    static long result;
    static void rCount(int a, int b, int c) {
        if (b == 1) {
            result = a % c;
            return;
        }

        rCount(a, b / 2, c);

        if (b % 2 == 0) {
            result = result * result % c;
        } else {
            result = (result * result % c) * a % c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        rCount(a, b, c);

        System.out.println(result);
    }
}

// TODO : mod 연산 -> (x * y) % z = ((x % z) * (y % z)) % z
// long 반환하는 것보다 static 으로 result 선언해서 저장하는 게 속도가 더 빠름
