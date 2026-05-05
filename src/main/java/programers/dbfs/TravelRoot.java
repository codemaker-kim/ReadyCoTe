package programers.dbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TravelRoot {

    // 시작점
    private static final String DEPARTURE = "ICN";
    private static final int TICKET_DEPARTURE = 0;
    private static final int TICKET_ARRIVE = 1;

    private static boolean[] visited;
    private static List<String> answer;

    public String[] solution(String[][] tickets) {
        // 항상 "ICN" 공항에서 출발한다.

        // 1. 주어진 항공권(티켓)은 모두 사용해야 한다.
        // 2. [a,b] -> a로부터 b로 가는 티켓

        // 3. 가능한 경로가 2개 이상일 경우, 알파벳 순서가 앞서는 경로 return
        // 4. 모든 도시를 방문할 수 없는 경우는 없음.

        // output? -> 모든 공항을 거쳐가는 순서
        // 여러번 들르는 공항이 있을 수도 있음.

        // solution?
        // 1. ICN에서 출발하며, 도착하는 공항의 이름이 오름차순보다 큰 공항 찾는다.
        // 2. 도착한 공항에서 출발하는 티켓을 찾는다.
        // 종료까지 무한 반복.
        // !! 가능한 경로 + 알파벳으로 앞서는거를 쓰라는 거였음
        // 시@발 존나 어이 없네

        visited = new boolean[tickets.length];
        answer = new ArrayList<>();

        String[][] sortedTickets = Arrays.stream(tickets).
                sorted((ticket1, ticket2) -> ticket1[TICKET_ARRIVE].compareTo(ticket2[TICKET_ARRIVE]))
                .toArray(String[][]::new);

        answer.add(DEPARTURE);

        backTrack(DEPARTURE, sortedTickets);

        return answer.toArray(String[]::new);
    }

    private boolean backTrack(String current, String[][] tickets) {
        // 종료 조건: 정답 리스트 사이즈가 공항 수와 같아졌을 때
        if (answer.size() == tickets.length + 1)
            return true;

        for (int index = 0; index < tickets.length; index++) {
            // 다음 출발지 찾기
            if (!visited[index] && tickets[index][TICKET_DEPARTURE].equals(current)) {
                // 방문 처리
                visited[index] = true;
                String nextDeparture = tickets[index][TICKET_ARRIVE];

                answer.add(nextDeparture);
                if (backTrack(nextDeparture, tickets)) {
                    return true;
                } else {
                    // 실패 시 롤백
                    visited[index] = false;
                    answer.remove(answer.size() - 1);
                }
            }
        }

        return false;
    }
}
