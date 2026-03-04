package programers.dbfs;

import java.util.Stack;

public class TargetNumber {

    class State {
        int index;
        int sum;

        State(int index, int sum) {
            this.index = index;
            this.sum = sum;
        }
    }

    public int solution(int[] numbers, int target) {
        int answer = 0;
        Stack<State> stack = new Stack<>();

        stack.push(new State(0, 0));

        while (!stack.isEmpty()) {
            State current = stack.pop();

            if (current.index == numbers.length) {
                if (current.sum == target) {
                    answer++;
                }
            } else {
                stack.push(new State(current.index + 1, current.sum + numbers[current.index]));
                stack.push(new State(current.index + 1, current.sum - numbers[current.index]));
            }
        }

        return answer;
    }
}
