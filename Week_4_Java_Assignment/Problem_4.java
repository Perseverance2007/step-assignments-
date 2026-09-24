import java.util.*;

/*
 * Problem 4: Subarray Sum Equals K
 * Counts the number of contiguous subarrays whose sum equals k,
 * using running prefix sums combined with a hash map of frequencies.
 */
public class Problem_4 {

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // empty prefix has sum 0

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            // If (sum - k) has been seen before, those earlier points mark
            // the start of a subarray ending here that sums to k
            count += prefixSumCount.getOrDefault(sum - k, 0);
            prefixSumCount.put(sum, prefixSumCount.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = 2");
        System.out.println("Count: " + subarraySum(nums1, 2));

        int[] nums2 = {1, -1, 0};
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = 0");
        System.out.println("Count: " + subarraySum(nums2, 0));
    }
}
