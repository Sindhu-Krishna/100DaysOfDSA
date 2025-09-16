/*
When the array can have negative numbers, the sliding window trick breaks (because shrinking the window no longer guarantees decreasing the sum).
In that case, we use a prefix sum + HashMap:
- Keep running sum.
- If (currentSum - target) is seen before, then the subarray between those indices adds to target.
- Store prefix sums with their earliest index.
 */

import java.util.*;

public class SubarrayWithGivenSumHashMap {
    public static void findSubarray(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // Case 1: subarray from start to i
            if (sum == target) {
                System.out.println("Subarray found from index 0 to " + i);
                return;
            }

            // Case 2: subarray ending at i (check if sum - target seen before)
            if (map.containsKey(sum - target)) {
                System.out.println("Subarray found from index " + (map.get(sum - target) + 1) + " to " + i);
                return;
            }

            // store prefix sum with index
            map.putIfAbsent(sum, i);
        }

        System.out.println("No subarray with given sum found.");
    }

    public static void main(String[] args) {
        int[] arr1 = { 10, 2, -2, -20, 10 };
        int target1 = -10;

        int[] arr2 = { 1, 4, 20, 3, 10, 5 };
        int target2 = 33;

        findSubarray(arr1, target1); // Expected: 0 to 3
        findSubarray(arr2, target2); // Expected: 2 to 4
    }
}
