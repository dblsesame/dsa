package leetcode.practice.queue;
import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> calls = new LinkedList<>();
    public int ping(int t) {
        calls.offer(t);
        //check if the first element is within 3000 ms
        while (calls.peek() < t-3000) {
            calls.poll();
        }   
        return calls.size();
    }
}
