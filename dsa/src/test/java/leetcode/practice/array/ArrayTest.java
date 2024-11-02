package leetcode.practice.array;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/**
 * https://dzone.com/articles/7-popular-unit-test-naming
 * key elements for test cases:
 *  - a. method name
 *  - b. state under test
 *  - c. expected behavior
 * Naming convention:
 *  a_B_C 
 *  a_C_B
 *  testABC
 *  Should_C_When_B
 *  When_B_Expect_C
 *  Given_D_When_B_Then_C
 * using test[FeatureBeingTested]
 *  - drawback: test is redundent
 */
public class ArrayTest {

    @Test
    public void testLongestSum(){
        int[] nums = {3, 1, 2, 7, 4, 2,1,1,5};
        SlidingWindow slw  = new SlidingWindow();

        assertEquals(4, slw.longestSubarraySum(nums, 8));
    }

    @Test
    public void testLongestOnes(){
        String str = "11101100111";
        SlidingWindow slw = new SlidingWindow();

        assertEquals(6, slw.longestOnes(str));
    }

    @Test 
    public void testSubarraysProductLessThanK(){
        int[] nums = {10, 5, 2, 6};
        int k = 100;
        SlidingWindow sld = new SlidingWindow();

        assertEquals(8, sld.numberOfSubarraysProductLessThanK(nums, k));
    }

    @Test
    public void testMaxAverage(){
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        SlidingWindow slw = new SlidingWindow();

        assertEquals(12.75, slw.findMaxAverage(nums, k));
    }

    @Test
    public void testLongestOnesIII(){
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        SlidingWindow slw = new SlidingWindow();

        assertEquals(6, slw.longestOnesIII(nums, k));
    }

    @Test
    public void testKRadiusAverages(){
        int [] nums = {7,4,3,9,1,8,5,2,6};
        int k = 3;
        PrefixSum pfs = new PrefixSum();
        int[] ans = {-1,-1,-1,5,4,4,-1,-1,-1};
        assertArrayEquals(ans, pfs.getKRadiusAverages(nums, k));

    }
}
