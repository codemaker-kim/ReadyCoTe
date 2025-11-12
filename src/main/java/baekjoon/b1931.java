package baekjoon;

import static java.util.Comparator.comparingInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class b1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer[]> meetingTimes = new ArrayList<>();

        int result = 1;

        // 회의 시간들을 리스트에 저장.
        for (int i = 0; i < N; i++) {
            Integer[] meeting = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            meetingTimes.add(meeting);
        }

        // 회의 종료 시간을 기준으로 정렬,
        // 회의 종료 시간이 같다면, 회의 시작 시간 기준으로 정렬
        meetingTimes.sort(
                comparingInt((Integer[] meeting) -> meeting[1])
                        .thenComparingInt(meeting -> meeting[0])
        );

        Integer[] beforeMeeting = meetingTimes.get(0);

        for (int i = 0; i < meetingTimes.size(); i++) {
            // 회의 확인 처리
            Integer[] nextMeeting = meetingTimes.get(i);

            // 이전 회의 종료 시간
            int beforeMeetingFinishTime = beforeMeeting[1];

            // 이전 회의 종료 시간이 다음 회의 시작 시간보다 작거나 같으면
            // 갯수를 하나 증가시키고, 이전 회의를 다음 회의로 변경
            if (beforeMeetingFinishTime <= nextMeeting[0]) {
                result++;
                beforeMeeting = nextMeeting;
            }
        }

        System.out.println(result);
    }
}
