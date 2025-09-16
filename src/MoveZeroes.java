public class MoveZeroes {
    public static void moveZeroes(int[] arr) {
        int n = arr.length;
        int nonZeroIndex = 0; // where next non-zero should go

        // move all non-zero to front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZeroIndex++] = arr[i];
            }
        }

        // fill rest with zeroes
        while (nonZeroIndex < n) {
            arr[nonZeroIndex++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        moveZeroes(arr);

        System.out.println("Array after moving zeroes:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
