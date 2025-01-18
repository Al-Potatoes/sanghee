package recursion;


import java.util.Scanner;

public class Q2581 {
    int[] array;

    public int rFindScore(int n,int sum){
        if(n==10){
            return sum;
        }

        int newSum = array[n]+sum;
        if(Math.abs(100 - newSum)<= Math.abs(100 - sum)) {
            return rFindScore(n + 1, newSum);
        }

        return sum;
    }
    public void solution(){
        Scanner sc = new Scanner(System.in);

        array = new int[10];
        for(int i = 0; i<10; i++){
            array[i] = sc.nextInt();
        }


        int result = rFindScore(0, 0);


        System.out.println(result);

        sc.close();
    }

    public static void main(String[] args) {
        new Q2581().solution();
    }
}

// TODO : 정신 차리기, 문제를 제대로 읽자 !
