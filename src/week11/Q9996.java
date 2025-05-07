package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9996 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String p = br.readLine();
        StringBuilder sb = new StringBuilder();

        String[] pat = p.split("\\*");

        for(int i = 0; i < n; i++){
            String f = br.readLine();

            if(pat[0].length()+pat[1].length() <= f.length()){
                if(f.startsWith(pat[0]) && f.endsWith(pat[1])){
                    sb.append("DA").append("\n");
                }
                else{
                    sb.append("NE").append("\n");
                }
            }
            else{
                sb.append("NE").append("\n");
            }
        }
        System.out.print(sb);
    }
}

// 14248KB	100ms
/* TODO : 1. String엔 startsWith와 endsWith가 있다
          2. 정규표현식
          정규표현식: a.*b 설명
          a: 문자 a를 정확히 매칭
          .: 줄바꿈(\n)을 제외한 모든 문자(알파벳, 숫자, 특수문자 등)를 의미
          *: 앞의 패턴(.)이 0개 이상 반복
          b: 문자 b를 정확히 매칭
 */
