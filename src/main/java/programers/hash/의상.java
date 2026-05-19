package programers.hash;

import java.util.HashMap;
import java.util.Map;

class 의상 {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        // 의상 종류명 인덱스
        final int kindIndex = 1;

        // 의상 해시 세팅
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[kindIndex])) {
                map.put(cloth[kindIndex], map.get(cloth[kindIndex]) + 1);
            } else {
                map.put(cloth[kindIndex], 2);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            answer *= entry.getValue();
        }

        return answer - 1;
    }
}
