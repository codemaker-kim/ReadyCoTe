package programers.greedy;

import java.util.Arrays;

class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        // 보트는 한 번에 최대 2명

        Arrays.sort(people);

        // 마지막 원소 인덱스
        int curIndex = 0;

        for (int i = people.length - 1; i >= 0; i--) {
            if (curIndex > i)
                break;

            // 가장 무거운 사람 + 가장 가벼운 사람이 구명보트 한계보다 작거나 같을 때
            if (i != curIndex) {
                if (people[i] + people[curIndex] <= limit) {
                    curIndex++;
                }
            }

            answer++;
        }

        return answer;
    }
}
