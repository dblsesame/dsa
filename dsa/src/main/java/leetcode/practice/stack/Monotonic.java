package leetcode.practice.stack;

import java.util.Stack;

public class Monotonic {

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        
        //stack to store the index of the temperatures
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<temperatures.length; i++) {
            //if the stack is not empty and the current temp is greater than the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                //pop the top of the stack and calculate the difference
                int index = stack.pop();
                result[index] = i - index; //days difference
            }
            //push the current index to the stack
            stack.push(i);
        }

/*         for (int i=0; i<temperatures.length; i++) {
            //on the ith day, with temperatures[i], check the next days
            for (int j=i+1; j<temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    result[i] = j-i;
                    break;
                }
            }
        } */
        return result;
    }
}
