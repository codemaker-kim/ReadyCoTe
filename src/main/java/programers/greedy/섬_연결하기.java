package programers.greedy;

import java.util.Arrays;
import java.util.Comparator;

class 섬_연결하기 {

    private static int[] parentNode;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        // n개의 섬 사이에 다리를 건설하는 비용 = costs
        // 최소 비용으로 모든 섬이 통행 가능하도록 만들기

        // costs[i][0], costs[i][1] = 연결되는 두 섬의 번호
        // cost[i][2] = 두 섬을 연결하는 다리를 건설할 때 드는 비용

        // 모든 섬 사이의 건설 비용이 주어지진 않음.
        parentNode = new int[n];

        for (int i = 0; i < n; i++) {
            parentNode[i] = i;
        }

        // 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, Comparator.comparingInt(cost -> cost[2]));

        for (int[] cost : costs)  {
            // Union-find 알고리즘을 이용.
            // 부모 노드가 같다면, 이미 연결되어 있는 상태.
            int node1 = find(parentNode[cost[0]]);
            int node2 = find(parentNode[cost[1]]);

            if (node1 == node2) {
                continue;
            }

            // 어느 한 쪽을 부모로 만든다.
            parentNode[node2] = node1;

            // 건설 비용을 증가시킨다.
            answer+=cost[2];
        }

        return answer;
    }

    private int find(int node) {
        if (node == parentNode[node])
            return node;

        return parentNode[node] = find(parentNode[node]);
    }
}
