/*
Problem:
Given an integer array arr[], check whether it is a palindrome — meaning it reads the same from the front and the back.

Example:
Input: arr = [1, 2, 3, 2, 1]
Output: true

Input: arr = [1, 2, 3]
Output: false
*/

public class PalindromeArray {
    public static boolean isPalindrome(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (arr[left] != arr[right])
                return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 1 };
        System.out.println("Is Palindrome? " + isPalindrome(arr));
    }
}
