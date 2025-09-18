/*
 Remove Duplicates from Sorted Array
 Topic: Two Pointers
 Goal: Remove duplicates from a sorted array in-place and return new length.
 */

public class RemoveDuplicates {
    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0)
            return 0;

        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 4 };
        int len = removeDuplicates(arr);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < len; i++)
            System.out.print(arr[i] + " ");
    }
}
