package programers.dbfs;

import java.util.LinkedList;
import java.util.Queue;

public class ItemPickUp {

    private static int[][] map;
    private static boolean[][] visited;
    private static final int CHARACTER = -2;
    private static final int ITEM = -1;
    private static final int OUT = 1;
    private static final int IN = 2;

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 변끼리 맞닿거나, 꼭짓점에서 만나는 경우, 지형이 2개인 경우도 없음
        // 사각형이 완전히 포함되는 경우도 없음
        // 캐릭터가 아이템을 줍기 위해 이동해야 하는 가장 짧은 거리
        // rectangle 배열의 행 길이는 1 이상 4 이하
        // 배열 형태
        // [좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y]
        // 최단거리니까 bfs, 테두리들을 찾는 로직?

        // 1. 게임 map을 하나 더 만든다.
        // 2. 캐릭터의 좌표와 아이템의 좌표는 결국 어느 사각형에는 존재함.
        // 3. 따라서 사각형 순회할 때마다 이에 대한 최단 경로를 지속적으로 갱신하는 방법으로 ㄱㄱ
        int answer = 0;
        map = new int[101][101];
        visited = new boolean[101][101];

        for (int[] element : rectangle) {
            int leftX = element[0] * 2;
            int leftY = element[1] * 2;

            int rightX = element[2] * 2;
            int rightY = element[3] * 2;

            for (int row = leftY; row <= rightY; row++) {
                for (int col = leftX; col <= rightX; col++) {
                    // 만약 사각형 내부가 아니라면
                    if (map[row][col] != IN && (row == leftY || row == rightY || col == leftX || col == rightX)) {
                        map[row][col] = OUT;
                    } else {
                        map[row][col] = IN;
                    }
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }

    private int bfs(int charX, int charY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        int[] character = new int[]{charX, charY, 0};
        queue.offer(character);

        while (!queue.isEmpty()) {
            character = queue.poll();
            int currX = character[0];
            int currY = character[1];
            int count = character[2];

            if (currX == itemX && currY == itemY) {
                return count / 2;
            }

            if (visited[currY][currX]) {
                continue;
            }

            // 방문 처리
            visited[currY][currX] = true;

            int nextCount = count + 1;

            if (currX + 1 < map.length && map[currY][currX + 1] == OUT) {
                queue.offer(new int[]{currX + 1, currY, nextCount});
            }

            if (currY + 1 < map[0].length && map[currY + 1][currX] == OUT) {
                queue.offer(new int[]{currX, currY + 1, nextCount});
            }

            if (currX - 1 >= 0 && map[currY][currX - 1] == OUT) {
                queue.offer(new int[]{currX - 1, currY, nextCount});
            }

            if (currY - 1 >= 0 && map[currY - 1][currX] == OUT) {
                queue.offer(new int[]{currX, currY - 1, nextCount});
            }
        }

        return character[2] / 2;
    }
}
