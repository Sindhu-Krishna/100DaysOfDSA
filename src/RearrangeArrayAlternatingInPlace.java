/*
- Partitioning positives and negatives (like QuickSort partition).
- Swapping elements to alternate them.
 */

public class RearrangeArrayAlternatingInPlace {

    // Utility to rotate subarray
    private static void rightRotate(int[] arr, int outOfPlace, int cur) {
        int temp = arr[cur];
        for (int i = cur; i > outOfPlace; i--) {
            arr[i] = arr[i - 1];
        }
        arr[outOfPlace] = temp;
    }

    public static void rearrange(int[] arr) {
        int n = arr.length;
        int outOfPlace = -1;

        for (int index = 0; index < n; index++) {
            if (outOfPlace >= 0) {
                // Check if element at outOfPlace and index are opposite signs
                if ((arr[outOfPlace] >= 0 && arr[index] < 0) ||
                        (arr[outOfPlace] < 0 && arr[index] >= 0)) {
                    rightRotate(arr, outOfPlace, index);

                    // Update outOfPlace index
                    if (index - outOfPlace >= 2) {
                        outOfPlace += 2;
                    } else {
                        outOfPlace = -1;
                    }
                }
            }

            // Mark outOfPlace
            if (outOfPlace == -1) {
                if (((arr[index] >= 0) && (index % 2 == 1)) ||
                        ((arr[index] < 0) && (index % 2 == 0))) {
                    outOfPlace = index;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -4, -1, 6, -9 };
        rearrange(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
