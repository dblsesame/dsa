package leetcode.practice.stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StackTest {
    @Test
    public void testSimplifyPath(){
        StackSolution stack = new StackSolution();
        String path = "/a/./b/../../c/";
        String result = stack.simplifyPath(path);
        assertEquals("/c", result);
    }
    @Test
    public void testSimplifyPathRoot(){
        StackSolution stack = new StackSolution();
        String path = "/../";
        String result = stack.simplifyPath(path);
        assertEquals("/", result);
    }
    @Test
    public void testSimplifyPath3Dots(){
        StackSolution stack = new StackSolution();
        String path = "/.../a/../b/c/../d/./";
        String result = stack.simplifyPath(path);
        assertEquals("/.../b/d", result);
    }
    @Test
    public void testSimplifyPathNot2Dots(){
        StackSolution stack = new StackSolution();
        String path = "/hello../world";
        String result = stack.simplifyPath(path);
        assertEquals("/hello../world", result);
    }
    public void testSimplifyPathNot1Dot(){
        StackSolution stack = new StackSolution();
        String path = "/hello./world";
        String result = stack.simplifyPath(path);
        assertEquals("/hello../world", result);
    }
    @Test
    public void testSimplifyPathRoot2(){
        StackSolution stack = new StackSolution();
        String path = "/a/../../b/../c//.//";
        String result = stack.simplifyPath(path);
        assertEquals("/c", result);
    }
    @Test
    public void testSimplifyPathRoot3(){
        StackSolution stack = new StackSolution();
        String path = "/a//b////c/d//././/..";
        String result = stack.simplifyPath(path);
        assertEquals("/a/b/c", result);
    }
    @Test
    public void testDailyTemperatures(){
        
        int[] temperatures = {90, 74, 75, 71, 69, 72, 76, 73};
        int[] result = Monotonic.dailyTemperatures(temperatures);
        int[] expected = {0, 1, 4, 2, 1, 1, 0, 0};
        
        assertArrayEquals(expected, result);
    }
}
