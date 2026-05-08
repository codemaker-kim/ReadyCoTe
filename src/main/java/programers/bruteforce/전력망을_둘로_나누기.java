package programers.bruteforce;

import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 1. 인접 리스트 형태로 그래프 빌드
        List<List<Integer>> graph = buildGraph(n, wires);
        int minDifference = Integer.MAX_VALUE;

        // 2. 모든 전선을 하나씩 순회하며 끊어보기 시뮬레이션
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // v1을 시작점으로 탐색하되, v2로 넘어가는 간선을 논리적으로 무시함 (끊은 효과)
            int count = countNodes(v1, v2, graph, n);

            // 3. 수식을 활용한 절댓값 차이 계산
            int difference = Math.abs(2 * count - n);
            minDifference = Math.min(minDifference, difference);
        }

        return minDifference;
    }

    /**
     * 무방향 그래프(트리)를 생성합니다.
     */
    private List<List<Integer>> buildGraph(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        return graph;
    }

    /**
     * BFS를 활용하여 start 노드와 연결된 송전탑의 개수를 셉니다.
     * 단, ignore 노드 방향으로는 탐색을 진행하지 않습니다.
     */
    private int countNodes(int start, int ignore, List<List<Integer>> graph, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        int count = 0; // 연결된 노드의 수

        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            for (int next : graph.get(current)) {
                // 이미 방문했거나, 끊어내기로 한 방향(ignore)이라면 패스
                if (!visited[next] && next != ignore) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
        return count;
    }
}