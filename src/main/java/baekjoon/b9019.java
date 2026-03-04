package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b9019 {

    private static boolean[] register;
    //private static int d1d2

    public static void main(String[] args) throws IOException {
        // D - n을 두배로, 9999보다 큰 경우는 10000로 나눈 나머지
        // S - n - 1을 레지스터에 저장. n=0이라면 9999을 대신 저장
        // L - n의 각 자릿수를 왼편으로 회전
        // d1 d2 d3 d4 -> d2 d3 d4 d1
        // R - n의 각 자릿수를 오른편으로 회전
        // d4 d1 d2 d3

        // TODO: A->B로 바꾸는 최소한의 명령어
        // n의 자릿수에 0이 포함된 경우를 고민해야함.
        // 1000 -> L 적용 시 0001 (1)
        // 1000 -> R 적용 시 0100 (100)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            register = new boolean[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            calculateMinQuery(A, B);
        }
    }

    private static void calculateMinQuery(int from, int to) {
        StringBuilder sb = new StringBuilder();

        // 행 : d1, d2번 열 : d3, d4번
        register[from] = true;
        register[to] = true;

        Queue<Integer> q = new LinkedList<>();
        q.offer(from);

        while(!q.isEmpty()){
            int index = q.poll();

        }

        System.out.println(sb.toString());
    }
}
