/*
Problem:
Given a sorted array of integers and a target sum, determine if there exists a pair of numbers in the array whose sum equals the target.
 
Example:
Input: arr = [1, 2, 4, 5, 7, 11], target = 9  
Output: true  (because 2 + 7 = 9)
*/

public class PairWithTargetSum {
    public static boolean hasPair(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target)
                return true;
            else if (sum < target)
                left++;
            else
                right--;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 7, 11 };
        int target = 9;

        System.out.println(hasPair(arr, target));
    }
}
