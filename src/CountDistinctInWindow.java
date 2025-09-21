import java.util.*;

public class CountDistinctInWindow {
    public int[] countDistinct(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < k; i++)
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        res[0] = map.size();
        for (int i = k; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.get(arr[i - k]) - 1);
            if (map.get(arr[i - k]) == 0)
                map.remove(arr[i - k]);
            res[i - k + 1] = map.size();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 4, 2, 3 };
        System.out.println(Arrays.toString(new CountDistinctInWindow().countDistinct(arr, 4)));
        // [3,4,4,3]
    }
}
