/* Sliding Window → Only for non-negative numbers.
We keep two pointers (start and end) and maintain a running sum:
- Expand end to add numbers.
- Shrink start while sum is greater than target.
If sum == target → found subarray.
 */

public class SubarrayWithGivenSum {
    public static void findSubarray(int[] arr, int target) {
        int n = arr.length;
        int start = 0, sum = 0;

        for (int end = 0; end < n; end++) {
            sum += arr[end]; // add current element

            // shrink window if sum > target
            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            // check if we got the target
            if (sum == target) {
                System.out.println("Subarray found from index " + start + " to " + end);
                return;
            }
        }

        System.out.println("No subarray with given sum found.");
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 4, 20, 3, 10, 5 };
        int target1 = 33;

        int[] arr2 = { 1, 2, 3, 7, 5 };
        int target2 = 12;

        findSubarray(arr1, target1); // Expected: 2 to 4
        findSubarray(arr2, target2); // Expected: 1 to 3
    }
}
