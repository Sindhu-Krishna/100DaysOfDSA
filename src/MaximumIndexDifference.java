/*
Problem:
Given an array arr[], find the maximum value of j - i such that arr[j] > arr[i] and j > i.

Example:
Input: arr = [34, 8, 10, 3, 2, 80, 30, 33, 1]
Output: 6   // (i=1, j=7 -> 33 > 8 and 7-1=6)
*/

public class MaximumIndexDifference {
    public static int maxIndexDiff(int[] arr) {
        int n = arr.length;
        int[] leftMin = new int[n];
        int[] rightMax = new int[n];

        // Fill leftMin[] so that leftMin[i] stores min from arr[0..i]
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftMin[i] = Math.min(arr[i], leftMin[i - 1]);

        // Fill rightMax[] so that rightMax[j] stores max from arr[j..n-1]
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--)
            rightMax[j] = Math.max(arr[j], rightMax[j + 1]);

        // Traverse both arrays using two pointers
        int i = 0, j = 0, maxDiff = -1;
        while (i < n && j < n) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int[] arr = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        System.out.println("Maximum Index Difference: " + maxIndexDiff(arr));
    }
}
