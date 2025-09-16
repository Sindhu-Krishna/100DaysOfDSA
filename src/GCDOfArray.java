public class GCDOfArray {
    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static int findArrayGCD(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = findGCD(result, arr[i]);

            if (result == 1)
                return 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 24, 36, 60 };
        int gcd = findArrayGCD(arr);
        System.out.println("GCD of array is: " + gcd);
    }
}
