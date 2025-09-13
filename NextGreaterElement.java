/*
Problem:
Given an array arr[] of size n, for each element find the Next Greater Element (NGE) — the first element to the right which is greater than the current element. If none exists, output -1.

Example:
Input: arr = [4, 5, 2, 25]
Output: [5, 25, 25, -1]
*/

import java.util.*;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 2, 25 };
        int[] nge = nextGreaterElements(arr);
        System.out.print("Next Greater Elements: ");
        for (int x : nge)
            System.out.print(x + " ");
        System.out.println();
    }
}
