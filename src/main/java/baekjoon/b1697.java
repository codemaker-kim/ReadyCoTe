package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1697 {

    private static boolean[] visited = new boolean[100001];
    private static final int VALUE = 0;
    private static final int TIME = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int result = 0;
        Queue<Integer[]> q = new LinkedList<>();

        q.offer(new Integer[]{N, 0});
        visited[N] = true;

        while (!q.isEmpty()) {
            // 큐에서 하나 꺼냄
            Integer[] current = q.poll();

            if (current[VALUE] == K) {
                result = current[TIME];
                break;
            }

            // 꺼낸 값에서 이동 진행
            int teleported = teleport(current[VALUE]);
            int leftWalked = left(current[VALUE]);
            int rightWalked = right(current[VALUE]);

            // 만약 방문하지 않았다면 큐에 넣음.
            if (!visited[teleported]) {
                q.offer(new Integer[]{teleported, current[TIME] + 1});
                visited[teleported] = true;
            }

            if (!visited[leftWalked]) {
                q.offer(new Integer[]{leftWalked, current[TIME] + 1});
                visited[leftWalked] = true;
            }

            if (!visited[rightWalked]) {
                q.offer(new Integer[]{rightWalked, current[TIME] + 1});
                visited[rightWalked] = true;
            }
        }

        System.out.println(result);
    }

    // 텔레포트
    private static int teleport(int index) {
        if (index * 2 > visited.length - 1)
            return index;

        return index * 2;
    }

    // 걷기
    private static int left(int index) {
        if (index <= 0) {
            return index;
        }

        return index - 1;
    }

    private static int right(int index) {
        if (index >= visited.length - 1) {
            return index;
        }

        return index + 1;
    }
}
