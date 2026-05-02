package programers.dbfs;

public class Network {

    private static final int CONNECTION = 1;

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        // 1. computers[i][j] -> i와 j가 연결되어 있음.
        // 2. computers는 행,열이 똑같음.
        // 3. i와 j가 연결되어 있을 때, j와 또 다른 컴퓨터 k가 연결되어 있다면
        // 그것도 하나의 네트워크 computer[i][j] - computer[j][k]는 하나의 네트워크
        int networks = 0;
        visited = new boolean[n];

        // 목표로 하는 컴퓨터의 연결하나를 고르고 끝까지 탐색
        // 컴퓨터의 개수만큼 반복 -> dfs

        // 1. 네트워크는 어떤 상태일때 +1이 되어야 하는가?
        // 2. 다음 컴퓨터로 넘어가는 조건은? computers 배열과 visited 배열의 상태는?
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                networks += 1;
                dfs(i, n, computers);
            }
        }

        return networks;
    }

    private void dfs(int node, int n, int[][] computers) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;

        for (int i = 0; i < n; i++) {
            // 같은 노드일경우에는 항상 1이므로 건너뜀.
            if (i == node) {
                continue;
            }

            if (!visited[i] && computers[node][i] == CONNECTION) {
                dfs(i, n, computers);
            }
        }
    }
}
