package baekjoon;

import java.util.Scanner;

public class b1916 {

    private static int[][] busMatrix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 도시의 개수
        int N = sc.nextInt();

        // 버스의 개수
        int M = sc.nextInt();

        // 버스 동선을 표기하기 위한 배열
        busMatrix = new int[N + 1][N + 1];

        for (int busCount = 0; busCount < M; busCount++) {
            int depart = sc.nextInt();
            int arrive = sc.nextInt();
            int price = sc.nextInt();

            busMatrix[depart][arrive] = price;
        }

        int targetDepart = Integer.parseInt(sc.next());
        int targetArrive = Integer.parseInt(sc.next());

        for (int departIndex = 1; departIndex <= N; departIndex++) {
            for (int arriveIndex = 1; arriveIndex <= N; arriveIndex++) {
                if (busMatrix[departIndex][arriveIndex] == 0)
                    continue;


            }
        }
    }
}
