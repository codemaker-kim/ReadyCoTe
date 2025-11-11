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

        // 가능한 회의는 최소 1개.
        int result = 1;

        for (int i = 0; i < N; i++) {
            Integer[] meeting = Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            meetingTimes.add(meeting);
        }

        meetingTimes.sort(
                comparingInt((Integer[] meeting) -> meeting[0])
                        .thenComparingInt(meeting -> meeting[1])
        );


        for (int i = 0; i < meetingTimes.size(); i++) {
            Integer[] meeting = meetingTimes.get(i);

            int count = 1;
            int beforeMeetingFinish = meeting[1];

            for (int j = 0; j < meetingTimes.size(); j++) {
                if (i == j)
                    continue;

                Integer[] nextMeeting = meetingTimes.get(j);

                if (beforeMeetingFinish <= nextMeeting[0]) {
                    count++;
                    beforeMeetingFinish = nextMeeting[1];
                }
            }

            if (count > result)
                result = count;
        }

        System.out.println(result);
    }
}
