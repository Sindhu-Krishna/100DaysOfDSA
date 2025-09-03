// An element is considered a leader if it is greater than or equal to all elements to its right. The rightmost element is always a leader.

public class LeadersInArray {
    public static void printLeaders(int[] arr) {
        int n = arr.length;
        int maxFromRight = arr[n - 1]; // last element is always leader
        System.out.print("Leaders: " + maxFromRight + " ");
        
        // go from right to left
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                System.out.print(maxFromRight + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        printLeaders(arr);
    }
}
