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

        for (int i = 0; i < N; i++) {
            Integer[] meeting = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            meetingTimes.add(meeting);
        }

        meetingTimes.sort(
                comparingInt((Integer[] meeting) -> meeting[1])
                        .thenComparingInt(meeting -> meeting[0])
        );

        Integer[] meeting = meetingTimes.get(0);

        for (int i = 0; i < meetingTimes.size(); i++) {
            Integer[] nextMeeting = meetingTimes.get(i);

            // 같은 회의의 경우 건너 뜀
            if (Arrays.equals(meeting, nextMeeting)) {
                continue;
            }

            // 회의 시작 시간이 같을 경우, 회의 시간이 짧은 쪽으로 변경
            if (meeting[0].equals(nextMeeting[0])) {
                if (calculateMeetingTime(meeting) > calculateMeetingTime(nextMeeting)) {
                    meeting = nextMeeting;
                }
            } else if (meeting[1] <= nextMeeting[0]) {
                result++;
                meeting = nextMeeting;
            }
        }

        System.out.println(result);
    }

    private static int calculateMeetingTime(Integer[] meeting) {
        return Math.abs(meeting[1] - meeting[0]);
    }
}
