package programers.hash;

import java.util.HashMap;
import java.util.Map;

class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        // 참여자명, 인원 수
        Map<String, Integer> map = new HashMap<>();
        String answer = "";

        // 참여자들 해시에 삽입
        for (String name : participant) {
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + 1);
            } else {
                map.put(name, 1);
            }
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)  {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }
}
