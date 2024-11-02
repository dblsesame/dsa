package leetcode.practice.array;
/** Sliding window problem usually asking you to find a subarry of an array.
 *  The idea behind sliding window is considering only valid subarrays.
 *  a subarray is defined by left bound and right bound.
 *  need to identify the constraint metric
 *  right - always expanding so we will do for loop on right
 *  left - as right expand, use left to shrink based on metric
 */
public class SlidingWindow {
    public int longestSubarraySum(int[] nums, int sum){
        int ans, left, right, currSum;
        ans = left = right = currSum =0;
        for (right=0; right <nums.length; right++){
            currSum +=nums[right];
            if (currSum > sum) {
                while (left<right && currSum > sum) {
                    currSum -= nums[left];
                    left ++;
                }
            }
            ans = Math.max(ans, right - left +1);
        }
        return ans;
    }

    public int longestOnes(String str) {
        int leng = 0;
        int left, currZero;
        left = currZero = 0;
        for (int right=0; right < str.length(); right++) {
            if (str.charAt(right) == '0') {
                currZero ++;
            }
            //just because the current position is zero doesn't mean we have to give up previous ones 
            while (currZero >1) {
                if (str.charAt(left) == '0') {
                    currZero --;
                }
                left ++;
            }
            //check the max length
            leng = Math.max(leng, right - left +1);
        }

        return leng;
    }
    /**
     * start from 0 expanding to the right, take away from the left
     * window is continuous 
     * @param nums
     * @param k
     * @return
     */
    public int numberOfSubarraysProductLessThanK(int[] nums, int k){
        int count =0;
        int left =0;
        int product = 1;
        // window (left, right) -> right - left +1 subarrays
        for(int right=0; right < nums.length; right ++) {
            product *= nums[right];
            while (product >= k) {
                //then take away the leftest element
                product /= nums[left];

                left++;
            }

            count += right - left +1;
        }
        return count;
        
    }

    /** 
     * fixed window
     */

    public double findMaxAverage(int[] nums, int k){
        //find the average of 1st window
        int sum=0;
        int ans=0;
        for (int i=0; i<k; i++){
            sum+= nums[i];
        }
        ans=sum;
        //move the window to the right starting from i=k, adding nums[i] and removing nums[i-k]
        for (int right = k; right < nums.length; right++){
            sum += nums[right];
            sum -= nums[right - k];
            ans = Math.max(ans, sum);
        }
        double ret = (double) ans/(double) k;
        return ret;
    }
/**
 * again the right end start from the left at 0, expending toward the end
 * while checking the condition, in this case num of zero in current window is less than or equal to k
 * if the condition fail, move the left boundary to keep condition true
 * @param str
 * @param k flip 0 k times
 * @return
 */
    public int longestOnesIII(int[] nums, int k) {
        int leng = 0;
        int left, currZero;
        left = currZero = 0;
        for (int right=0; right < nums.length; right++) {
            if (nums[right] == 0) {
                currZero ++;
            }
            //just because the current position is zero doesn't mean we have to give up previous ones 
            while (currZero >k) {
                if (nums[left] == 0) {
                    currZero --;
                }
                left ++;
            }
            //check the max length
            leng = Math.max(leng, right - left +1);
        }

        return leng;
    }
}
