package programers.hash;

import java.util.Arrays;

class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // 전화번호 목록
        // 전화번호부를 정렬하면, 유사한 번호끼리 뭉치게 될 것임.
        Arrays.sort(phone_book);

        // 내 번호가 누군가의 접두어라면, 누군가는..
        // 내 바로 뒤에 있겠지?
        // 접두어라면, 그렇게 정렬된 것들 중에, 가장 짧은 번호일 것임.
        for (int index = 0; index < phone_book.length - 1; index++) {
            String current = phone_book[index];

            if (phone_book[index + 1].startsWith(current)) {
                answer = false;
                break;
            }
        }

        return answer;
    }
}
