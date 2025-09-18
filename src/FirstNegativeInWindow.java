/*
First Negative Number in Every Window of Size K
Topic: Sliding Window + Deque
Goal: Print first negative number in every window of size k.
 */

import java.util.*;

public class FirstNegativeInWindow {
    public static void firstNegatives(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                dq.add(i);

            if (i >= k - 1) {
                while (!dq.isEmpty() && dq.peek() <= i - k)
                    dq.poll();

                if (!dq.isEmpty())
                    System.out.print(arr[dq.peek()] + " ");
                else
                    System.out.print("0 ");
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;
        firstNegatives(arr, k);
    }
}
