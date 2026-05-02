package programers.dbfs;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {

    private static final int IMPOSSIBLE = -1;
    private static final int WALL = 0;

    private Queue<int[]> queue;
    private boolean[][] visited;
    private int[] nx = {0, 0, -1, 1};
    private int[] ny = {-1, 1, 0, 0};

    public int solution(int[][] maps) {
        queue = new LinkedList<>();
        visited = new boolean[maps.length][maps[0].length];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pollX = poll[0];
            int pollY = poll[1];

            for (int i = 0; i < 4; i++) {
                int targetX = pollX + nx[i];
                int targetY = pollY + ny[i];

                // IndexOutOfBounds 방지, 갈 수 없는 곳 예외처리
                if (targetX < 0 || targetX >= maps.length ||
                        targetY < 0 || targetY >= maps[0].length ||
                        visited[targetX][targetY] || maps[targetX][targetY] == WALL) {
                    continue;
                }

                queue.offer(new int[]{targetX, targetY});
                visited[targetX][targetY] = true;

                maps[targetX][targetY] += maps[pollX][pollY];
            }
        }

        return visited[maps.length - 1][maps[0].length - 1] ?
                maps[maps.length - 1][maps[0].length - 1] :
                IMPOSSIBLE;
    }
}