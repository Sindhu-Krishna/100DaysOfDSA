/*
Problem:
Given a string s, check if it is a palindrome (reads the same forward and backward).
Ignore case sensitivity.
 
Example:
Input: "RaceCar"
Output: true

Input: "hello"
Output: false
 
Approach
Use two pointers: one at the start and one at the end.
Convert the string to lowercase.
Move both pointers towards the center, checking if characters match.
 */

public class PalindromeString {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "RaceCar";
        System.out.println("Is palindrome? " + isPalindrome(str));
    }
}
