/*
Problem:
Return the second largest element in the array.

Example: 
Input: [10, 5, 20, 8]
Output: 10
 */

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 20, 8 };
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int n : arr) {
            if (n > largest) {
                second = largest;
                largest = n;
            } else if (n > second && n != largest) {
                second = n;
            }
        }

        System.out.println("Second largest: " + second);
    }
}
