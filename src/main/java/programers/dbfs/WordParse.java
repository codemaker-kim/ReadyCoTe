package programers.dbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

public class WordParse {

    private static final int IMPOSSIBLE = 0;
    private boolean[] visited;
    private Queue<String> queue;

    public int solution(String begin, String target, String[] words) {
        int answer = IMPOSSIBLE;
        String currentWord = begin;

        // 변환 불가능한 경우에는 0 반환 - 빠른 종료
        if (Arrays.stream(words).noneMatch(target::equals)) {
            return answer;
        }

        visited = new boolean[words.length];
        queue = new LinkedList<>();

        // bfs 시작 전 초기화
        queue.offer(begin);

        /*
         * 고려사항
         * 1. words에 포함되었어도 변경가능한 경우도 있는가?
         * -> ㅇㅇ 한 번에 한 개의 단어로만 가능.
         * 2. 변경된 사항들을 어떻게 저장할 것인가?
         * -> words의 인덱스로 매핑한다. 결국 단어가 변할 수 있는 수치는 정해져있음 ㅇㅇ
         * */

        /*
         * 질문
         * 1. 카운트는 언제 어떻게 늘려야하는가?
         * 2. 방문 처리: 언제 visited 상태를 변경해야 하는가?
         * 3. 0을 반환해야 하는 명확한 상황. -> 완, 그 외에도 한 번에 2개 이상 변환이 필요할 때
         * 4. 종료 조건: poll했을 때의 target과 완벽일치할 때
         * 5. 변환 가능 기준? -> 정확하게 1개의 알파벳만이 다를 때
         * */


        // 찾았을 때 굳이 break 걸어야 하나?
        //
        while (!queue.isEmpty()) {
            String peek = queue.peek();

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String poll = queue.poll();

                if (poll.equals(target)) {
                    return answer;
                }

                if (!peek.equals(begin) && visited[getWordIndex(peek, words)])
                    continue;

                if (!peek.equals(begin))
                    visited[getWordIndex(poll, words)] = true;

                List<String> parsableWords = findParsableWords(poll, words);

                parsableWords.stream()
                        .filter(parsable -> !visited[getWordIndex(parsable, words)])
                        .forEach(queue::offer);
            }
            answer++;
        }

        return IMPOSSIBLE;
    }

    private List<String> findParsableWords(String current, String[] words) {
        List<String> parsableWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            int counter = 0;
            for (int j = 0; j < current.length(); j++) {
                if (current.charAt(j) != words[i].charAt(j)) {
                    counter++;
                }
            }

            if (counter == 1) {
                parsableWords.add(words[i]);
            }
        }

        return parsableWords;
    }

    private int getWordIndex(String current, String[] words) {
        return Arrays.asList(words)
                .indexOf(current);
    }
}
