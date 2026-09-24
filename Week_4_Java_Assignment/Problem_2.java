import java.util.*;

/*
 * Problem 2: Maximum Subarray (Kadane's Algorithm)
 * Finds the contiguous subarray with the largest sum. At each element,
 * decide whether to extend the current running subarray or start fresh.
 */
public class Problem_2 {

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the previous subarray or start a new one at nums[i]
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums2));
    }
}
