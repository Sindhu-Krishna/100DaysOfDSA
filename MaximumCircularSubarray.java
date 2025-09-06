/*
 Given a circular integer array nums of length n, return the maximum possible
 sum of a non-empty subarray of nums.
  
 A circular array means the end of the array connects to the beginning of the
 array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the
 previous element of nums[i] is nums[(i - 1 + n) % n].
  
 A subarray may only include each element of the fixed buffer nums at most
 once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does
 not exist i <= k1, k2 <= j with k1 % n == k2 % n.
  
  
 Example 1:
 Input: nums = [1,-2,3,-2]
 Output: 3
 Explanation: Subarray [3] has maximum sum 3.

 Example 2:
 Input: nums = [5,-3,5]
 Output: 10
 Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
 
 Example 3:
 Input: nums = [-3,-2,-3]
 Output: -2
 Explanation: Subarray [-2] has maximum sum -2.
*/

/*
 For the Maximum Circular Subarray Sum, there are two cases:
 - Normal subarray (non-circular) → Just use Kadane’s Algorithm.
 - Circular subarray → Max sum = Total sum – (minimum subarray sum).
 Finally, take the maximum of the two.
 Special case: If all numbers are negative, just return the maximum element
 (not 0).
*/

public class MaximumCircularSubarray {
    public static int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSoFar = Math.max(maxSoFar, currentSum);
        }
        return maxSoFar;
    }

    public static int maxCircularSubarraySum(int[] nums) {
        int maxKadane = kadane(nums); // normal max

        // if all elements are negative
        if (maxKadane < 0) {
            return maxKadane;
        }

        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; // invert for min subarray
        }

        int maxWrap = totalSum + kadane(nums); // total - minSubarray
        return Math.max(maxKadane, maxWrap);
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, -2, 3, -2 };
        int[] nums2 = { 5, -3, 5 };
        int[] nums3 = { -3, -2, -3 };

        System.out.println("Max Circular Subarray Sum (nums1): " + maxCircularSubarraySum(nums1));
        System.out.println("Max Circular Subarray Sum (nums2): " + maxCircularSubarraySum(nums2));
        System.out.println("Max Circular Subarray Sum (nums3): " + maxCircularSubarraySum(nums3));
    }
}
