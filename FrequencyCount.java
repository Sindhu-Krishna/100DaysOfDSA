/*
Problem:
Print each element and its count in the array.
 
Example:
Input: [1,2,2,3,1]
Output: 1->2, 2->2, 3->1
 */

import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2, 3, 1 };
        Map<Integer, Integer> freq = new HashMap<>();

        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        for (int key : freq.keySet()) {
            System.out.println(key + " -> " + freq.get(key));
        }
    }
}
