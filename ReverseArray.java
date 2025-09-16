/*
Problem:
Reverse an array without using extra space.

Example:
Input: [1,2,3,4]
Output: [4,3,2,1]
 */

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        for (int n : arr)
            System.out.print(n + " ");
    }
}
