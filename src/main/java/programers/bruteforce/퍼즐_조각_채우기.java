package programers.bruteforce;

class 퍼즐_조각_채우기 {

    // 상하좌우 좌표
    static final int[] nx = {-1, 1, 0, 0};
    static final int[] ny = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = -1;

        // 퍼즐 조각 테이블을 순회
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                // 빈 칸이라면 건너뜀.
                if (table[x][y] == 0)
                    continue;

                // 퍼즐 좌표만 리스트에 넣는다..

            }
        }

        return answer;
    }
}
