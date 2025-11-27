package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class b1043 {

    private static Queue<Integer> knowTruthPeoples;
    private static boolean[] visited;
    private static List<List<Integer>> parties;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 사람의 수
        int N = Integer.parseInt(sc.next());

        // 파티의 수
        int M = Integer.parseInt(sc.next());

        // 진실을 아는 사람의 수
        int knowTruthCount = Integer.parseInt(sc.next());

        knowTruthPeoples = new LinkedList<>();
        parties = new ArrayList<>();
        visited = new boolean[N + 1];

        // 해봐야 50번
        for (int index = 0; index < knowTruthCount; index++) {
            int peopleNumber = Integer.parseInt(sc.next());

            knowTruthPeoples.add(peopleNumber);
            visited[peopleNumber] = true;
        }

        // 50 * 50 -> 2500번 정도
        for (int partyNum = 0; partyNum < M; partyNum++) {
            int partyPeopleCount = Integer.parseInt(sc.next());

            List<Integer> partyPeoples = new ArrayList<>();

            for (int peopleIndex = 0; peopleIndex < partyPeopleCount; peopleIndex++) {
                int people = Integer.parseInt(sc.next());

                partyPeoples.add(people);
            }

            parties.add(partyPeoples);
        }

        printResult();

        sc.close();
    }

    private static void printResult() {
        int result = 0;

        while(!knowTruthPeoples.isEmpty()) {
            int peopleNum = knowTruthPeoples.poll();

            for (List<Integer> party : parties) {
                if (party.contains(peopleNum)) {
                    party.forEach(people -> {
                        if (!visited[people]) {
                            knowTruthPeoples.add(people);
                            visited[people] = true;
                        }
                    });
                }
            }
        }

        for (List<Integer> party : parties) {
            boolean liable = true;

            for (int people : party) {
                if (visited[people]) {
                    liable = false;
                    break;
                }
            }

            if (liable)
                result ++;
        }

        System.out.println(result);
    }
}
