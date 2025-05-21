package leetcode.practice.queue;

import org.junit.jupiter.api.Test;

public class MovingAverageTest {
    @Test
    public void test1() {
        MovingAverage m = new MovingAverage(3);
        assert m.next(1) == 1.0;
        assert m.next(10) == 5.5;
        assert m.next(3) == 4.666666666666667;
        assert m.next(5) == 6.0;
    }
}
