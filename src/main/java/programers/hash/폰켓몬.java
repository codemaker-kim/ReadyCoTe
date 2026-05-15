package programers.hash;

import java.util.HashMap;
import java.util.Map;

class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;

        // 폰켓몬 번호와 갯수
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 최댓값은 nums 배열의 길이의 절반.
        for (int index = 0; index < map.size(); index++) {
            if (answer >= nums.length / 2) break;
            answer++;
        }

        return answer;
    }
}
