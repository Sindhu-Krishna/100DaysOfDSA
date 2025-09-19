/*
Move All Negative Numbers to Beginning
Topic: Two Pointers (Partitioning)
Goal: Rearrange so all negative numbers come before positive numbers.
 */

public class MoveNegatives {
    public static void moveNegatives(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            if (arr[left] < 0) {
                left++;
            } else if (arr[right] >= 0) {
                right--;
            } else {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, -2, 3, -4, 5, -6};
        moveNegatives(arr);
        for (int x : arr) System.out.print(x + " ");
    }
}
