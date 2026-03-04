package programers.dbfs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TargetNumberTest {

    @Test
    public void testSolution() {
        TargetNumber tn = new TargetNumber();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        assertEquals(expected, tn.solution(numbers, target));
    }

    @Test
    public void testSolution2() {
        TargetNumber tn = new TargetNumber();
        int[] numbers = {4, 1, 2, 1};
        int target = 4;
        int expected = 2;
        assertEquals(expected, tn.solution(numbers, target));
    }
}
