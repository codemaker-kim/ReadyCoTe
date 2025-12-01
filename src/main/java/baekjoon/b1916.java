package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b1916 {

    private static int N, M;
    private static ArrayList<ArrayList<int[]>> graph;
    private static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new int[]{end, cost});
        }

        st = new StringTokenizer(br.readLine());
        int startNode = Integer.parseInt(st.nextToken());
        int endNode = Integer.parseInt(st.nextToken());

        dijkstra(startNode);

        System.out.println(dist[endNode]);
    }

    private static void dijkstra(int start) {
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 우선순위 큐 생성
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        // 시작점, 비용 0 추가
        pq.add(new int[]{start, 0});
        dist[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curIdx = current[0]; // 도시 번호
            int curCost = current[1]; // 비용

            if (curCost > dist[curIdx]) {
                continue;
            }

            // 연결된 다음 노드들을 확인
            for (int[] next : graph.get(curIdx)) {
                int nextNode = next[0];
                int nextCost = next[1];

                if (dist[nextNode] > curCost + nextCost) {
                    dist[nextNode] = curCost + nextCost;

                    // 큐에 배열로 넣기
                    pq.offer(new int[]{nextNode, dist[nextNode]});
                }
            }
        }
    }
}
