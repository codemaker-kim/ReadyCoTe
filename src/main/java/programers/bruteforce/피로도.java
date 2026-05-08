package programers.bruteforce;

class solution {

    private static boolean[] visited;
    private static int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        calculateMaxExploreCount(k, dungeons, 0);

        return maxCount;
    }

    public void calculateMaxExploreCount(int k, int[][] dungeons, int count) {
        maxCount = Math.max(maxCount, count);

        for (int index = 0; index < dungeons.length; index++) {
            int[] dungeon = dungeons[index];

            if (visited[index] || dungeon[0] > k) {
                continue;
            }

            // DO & RECURSE
            visited[index] = true;
            calculateMaxExploreCount(k - dungeon[1], dungeons, count + 1);

            // BACKTRACK
            visited[index] = false;
        }
    }
}
