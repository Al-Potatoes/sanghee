package heap;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Q7662 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int elem = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    map.put(elem, map.getOrDefault(elem, 0) + 1);
                }
                else if (op.equals("D") && !map.isEmpty()) {
                    int findNum;

                    if (elem == 1) { // 최댓값
                        findNum = map.lastKey();
                    } else { // 최솟값
                        findNum = map.firstKey();
                    }

                    if (map.get(findNum) > 1) {
                        map.put(findNum, map.get(findNum) - 1);
                    } else {
                        map.remove(findNum);
                    }
                }
            }

            if (map.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(String.format("%s %s\n", map.lastKey(), map.firstKey()));
            }
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        new Q7662().solution();
    }
}

// TODO : 문제를 똑바로 읽자 -> 각 연산 사이클마다 새로운 큐
