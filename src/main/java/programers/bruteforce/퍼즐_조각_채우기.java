package programers.bruteforce;

class 퍼즐_조각_채우기 {

    // 상하좌우 좌표
    static final int[] nx = {-1, 1, 0, 0};
    static final int[] ny = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        // 퍼즐 조각 테이블을 순회
        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[x].length; y++) {
                // 빈 칸이라면 건너뜀.
                if (table[x][y] == 0)
                    continue;

                // 퍼즐을 찾는다.
                int[][] piece = findPuzzlePiece(x, y, table);

                // 퍼즐이 맞는 위치를 찾는다.
                answer+=fitPuzzle(piece, game_board);
            }
        }

        return answer;
    }

    private int[][] findPuzzlePiece(int x, int y, int[][] table) {
        // 퍼즐의 최대 사이즈로 생성
        int[][] result = new int[6][6];

        return result;
    }

    private int fitPuzzle(int[][] piece, int[][] gameBoard) {
        return 0;
    }
}
