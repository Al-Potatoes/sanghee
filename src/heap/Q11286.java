package heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q11286 {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer a, Integer b) { // 내림차순 : a > b -> 양수, 오름차순 : a < b -> 양수
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA - absB == 0) {
                if (a > b) {
                    return 1;
                } else {
                    return -1;
                }
            }

            return absA - absB;
        }
    });

    public void solution() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (!priorityQueue.isEmpty()) {
                    System.out.println(priorityQueue.remove());
                } else {
                    System.out.println(0);
                }
            } else {
                priorityQueue.add(num);
            }
        }
    }

    public static void main(String[] args) {
        new Q11286().solution();
    }
}
