/*
Problem:
Given an array arr[] of length n and an integer k, find the maximum element of each subarray of size k.
 
Example:
Input: arr = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
 */

public class MaxOfSubarraysBrute {
    public static void maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            int max = arr[i];
            for (int j = i; j < i + k; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            System.out.print(max + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        System.out.print("Maximums of all subarrays of size " + k + ": ");
        maxOfSubarrays(arr, k);
    }
}
