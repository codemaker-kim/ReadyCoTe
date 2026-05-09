package programers.bruteforce;

class 모음사전 {

    private static int count;

    public int solution(String word) {
        int answer = 0;
        count = 0;
        if (isSameWithTarget(word, ""))
            answer = count;

        return answer;
    }

    public boolean isSameWithTarget(String target, String current) {
        if (target.equals(current))
            return true;

        if (current.length() == 5)
            return false;

        String[] vowels = {"A", "E", "I", "O", "U"};

        for (int i = 0; i < 5; i++) {
            count++;
            if (isSameWithTarget(target, current + vowels[i])) {
                return true;
            }
        }

        return false;
    }
}