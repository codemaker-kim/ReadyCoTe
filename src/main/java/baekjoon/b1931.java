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

        // 회의 시간이 가장 짧고, 시작시간이 가장 작은 회의
        meetingTimes.sort(
                comparingInt((Integer[] meeting) -> meeting[1])
                        .thenComparingInt(meeting -> meeting[0])
                        .thenComparingInt(meeting -> meeting[1] - meeting[0])
        );

        Integer[] beforeMeeting = meetingTimes.get(0);

        for (int i = 1; i < meetingTimes.size(); i++) {
            Integer[] nextMeeting = meetingTimes.get(i);

            if (beforeMeeting[1] <= nextMeeting[0]) {
                result++;
                beforeMeeting = nextMeeting;
            }
        }

        System.out.println(result);
    }
}
