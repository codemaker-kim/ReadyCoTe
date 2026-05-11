package programers.bruteforce;

import java.util.ArrayList;
import java.util.List;

class 카펫 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        List<int[]> yellowCombi = new ArrayList<>();

        // 가로길이는 세로보다 크거나 같다
        // 도형 가로, 세로 = 노랑 직사각형의 가로 + 2, 노랑 직사각형의 세로 + 2
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i != 0)
                continue;

            int row = yellow / i;

            if (row < i)
                continue;

            yellowCombi.add(new int[]{row, i});
        }

        // 구한 값들 중에서, 가로 길이가 세로보다 짧거나 긴 값.
        for (int[] combi : yellowCombi) {
            // yellow의 조합일 때 예상되는 brown의 값
            int expected = combi[0] * 2 + combi[1] * 2 + 4;

            if (brown == expected) {
                answer = new int[]{combi[0] + 2, combi[1] + 2};
                break;
            }
        }

        return answer;
    }
}
