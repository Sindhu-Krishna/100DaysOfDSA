public class BookAllocation {
    private boolean isPossible(int[] pages, int students, int mid) {
        int count = 1, sum = 0;
        for (int p : pages) {
            if (p > mid)
                return false;
            if (sum + p > mid) {
                count++;
                sum = p;
                if (count > students)
                    return false;
            } else
                sum += p;
        }
        return true;
    }

    public int findPages(int[] pages, int students) {
        int low = 0, high = 0, ans = -1;
        for (int p : pages)
            high += p;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(pages, students, mid)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] pages = { 12, 34, 67, 90 };
        System.out.println(new BookAllocation().findPages(pages, 2)); // 113
    }
}
