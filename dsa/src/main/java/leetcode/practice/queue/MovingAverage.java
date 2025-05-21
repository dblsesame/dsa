package leetcode.practice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size=1;
    Queue<Integer> values = new LinkedList<>();
    int sum = 0;
    public MovingAverage(int size) {
        this.size = size;
    }

    public double next(int val) {
        values.offer(val);
        sum += val;
        if (values.size() > size) {
            //values.poll();
            sum -= values.poll();
        }

        return (double) sum / values.size();
    }
}
