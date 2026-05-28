package programers.greedy;

import java.util.Arrays;
import java.util.Comparator;

class 단속카메라 {

    public int solution(int[][] routes) {
        int answer = 0;
        // 모든 차량이 한번은 카메라 만나도록
        // 최소로 설치해야하는 카메라 개수
        // index 0: 진입 시점
        // index 1: 진출 시점

        // 단속 탈출이 빠른 순서대로 정렬
        Arrays.sort(routes,
                Comparator.comparing((route) -> route[1])
        );

        int lastDeadLine = Integer.MIN_VALUE;

        // 탈출이 빠른 순서대로 진행
        for (int[] route : routes) {
            // 만약 다음 출발 시간이 마지막 데드라인보다 크면
            if (route[0] > lastDeadLine) {
                lastDeadLine = route[1];
                answer+=1;
            }
        }

        return answer;
    }
}
