package leetcode.practice.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RecentCounterTest {
    @Test
    public void test1() {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        //System.out.println(recentCounter.ping(4000));
        assertEquals(2, recentCounter.ping(4000));
    }
}
