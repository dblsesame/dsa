package leetcode.practice.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExistenceTest {
    @Test
    public void testMaxBalloonsZero() {
        String text="balon";
        Existence existence = new Existence();
        assertEquals(0, existence.maxNumberOfBalloons(text));
    }
    @Test
    public void testMaxBalloonsOne() {
        String text="nlaebolko";
        Existence existence = new Existence();
        assertEquals(1, existence.maxNumberOfBalloons(text));        
    }

    @Test
    public void testLongestSubstring(){
        String s = "abccddca";
        Existence existence = new Existence();
        assertEquals(3, existence.lengthOfLongestSubstring(s));
    }
}
