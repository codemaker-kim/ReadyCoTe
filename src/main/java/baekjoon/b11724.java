package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b11724 {

    private static ArrayList<Integer>[] connection;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        visited = new boolean[N + 1];
        connection = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            connection[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            connection[u].add(v);
            connection[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for (int nextNode : connection[node]) {
            if (!visited[nextNode]) {
                dfs(nextNode);
            }
        }
    }
}
