package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            char a = input.charAt(i);

            char res = a;
            if(Character.isUpperCase(a)){
                res = (char)((a - 'A' + 13) % 26 + 'A');
            }
            else if(Character.isLowerCase(a)){
                res = (char)((a - 'a' + 13) % 26 + 'a');
            }

            sb.append(res);
        }

        System.out.println(sb);
    }
}
