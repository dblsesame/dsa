package leetcode.practice.array;

import java.util.Arrays;

public class PrefixSum {
    /**
     * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
     * Return the running sum of nums.
     * @param nums
     */
    public int[] runningSum(int[] nums){
        int[] sums = new int[nums.length];
        sums[0]=nums[0];
        for (int i=1; i< nums.length; i++){
            sums[i]=nums[i]+sums[i-1];
        }
        return sums;
    }

    public int minStartValue(int[] nums) {
        int  startVal =1;
        int sum =0;
        for (int i=0; i< nums.length; i++){
            sum += nums[i];
            startVal = Math.min(startVal, sum);
        }
        startVal = 1- startVal;
        if (startVal < 1) startVal=1;

        return startVal;
    }

    public int[] getKRadiusAverages(int[] nums, int k) {
        //this also looks like a fixed size sliding window
        // instead of doing all the sum, do the first subarray
        // and decrease the left while adding the right for next sum
        
        //using int type fails when sum larger the max int (case 39 10000)
        if (k == 0) {
            return nums;
        }
        int[] avg = new int[nums.length];
        Arrays.fill(avg, -1);
        if(k>nums.length) {
            //all the elements of the avg should be -1
            return avg;
        }
 
        int[] sum = runningSum(nums);

        for (int i=k; i<(nums.length-k); i++){
            if (i-k-1 >= 0)
                avg[i]=(sum[i+k] - sum[i-k-1]) /(2*k +1);
            else 
                avg[i]=(sum[i+k]) /(2*k +1);   
        }
        return avg;
    }
}
