public class CheckSortedRotated {
    public static boolean isSortedAndRotated(int[] arr) {
        int n = arr.length;
        int dropCount = 0; // count how many times order breaks

        for (int i = 0; i < n; i++) {
            // compare current with next (circular check using %)
            if (arr[i] > arr[(i + 1) % n]) {
                dropCount++;
            }
            if (dropCount > 1) {
                return false; // if breaks more than once, not sorted+rotated
            }
        }
        return dropCount == 1;
    }

    public static void main(String[] args) {
        int[] arr1 = { 3, 4, 5, 1, 2 };
        int[] arr2 = { 1, 2, 3, 4, 5 };
        int[] arr3 = { 3, 5, 4, 1, 2 };

        System.out.println("Array 1 is sorted & rotated? " + isSortedAndRotated(arr1));
        System.out.println("Array 2 is sorted & rotated? " + isSortedAndRotated(arr2));
        System.out.println("Array 2 is sorted & rotated? " + isSortedAndRotated(arr3));
    }
}
