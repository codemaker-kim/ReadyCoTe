package programers.stackq;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

class 프로세스 {
    public int solution(int[] priorities, int location) {
        // 큐에서 하나 꺼냄
        // 대기중인 프로세스 중 , 우선순위가 더 높은 프로세스가 있다면,
        // 방금 꺼낸 프로세스를 다시 큐에 넣는다.
        // 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행한다.
        int answer = 0;

        // priorities의 숫자가 클 수록 우선순위가 높음
        Queue<Integer> queue = Arrays.stream(priorities)
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));

        int max = queue.stream()
                .max(Integer::compareTo)
                .get();

        while (true) {
            int poll = queue.poll();

            if (poll == max) {
                answer++;
                if (location == 0)
                    break;
                location--;
                max =  queue.stream()
                        .max(Integer::compareTo)
                        .get();
            } else {
                queue.offer(poll);

                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            }
        }

        return answer;
    }
}
