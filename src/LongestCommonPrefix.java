import java.util.*;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0], last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i))
            i++;
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        String[] arr = { "flower", "flow", "flight" };
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(arr)); // "fl"
    }
}
