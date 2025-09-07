public class RearrangeArrayAlternating {
    public static void rearrange(int[] arr) {
        int n = arr.length;

        // Step 1: Partition array into positives and negatives
        int[] pos = new int[n];
        int[] neg = new int[n];
        int p = 0, q = 0;

        for (int num : arr) {
            if (num >= 0)
                pos[p++] = num;
            else
                neg[q++] = num;
        }

        // Step 2: Merge alternately
        int i = 0, j = 0, k = 0;
        boolean turnPos = true; // start with positive

        while (i < p && j < q) {
            if (turnPos) {
                arr[k++] = pos[i++];
            } else {
                arr[k++] = neg[j++];
            }
            turnPos = !turnPos;
        }

        // Step 3: Add remaining elements
        while (i < p)
            arr[k++] = pos[i++];
        while (j < q)
            arr[k++] = neg[j++];
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, -4, -1, 6, -9 };
        rearrange(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
