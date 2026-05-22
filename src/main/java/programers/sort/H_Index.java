package programers.sort;

import java.util.Arrays;
import java.util.Collections;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;

        // 조건 1. h번 이상 인용되어야 함.
        // 조건 2. 조건1을 만족하는 원소가 h개 이상일 때
        // h의 최댓값이 이 과학자의 H-Index
        int[] sorted = Arrays.stream(citations)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        for (int i = 0; i < sorted.length; i++) {
            if (i >= sorted[i]) {
                answer = i;
                break;
            }

            if (i == sorted.length - 1)
                answer = i + 1;
        }

        return answer;
    }
}