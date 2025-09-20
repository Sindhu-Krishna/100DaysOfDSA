public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (dfs(board, word, i, j, 0))
                    return true;
        return false;
    }

    private boolean dfs(char[][] b, String w, int i, int j, int idx) {
        if (idx == w.length())
            return true;
        if (i < 0 || j < 0 || i >= b.length || j >= b[0].length || b[i][j] != w.charAt(idx))
            return false;
        char c = b[i][j];
        b[i][j] = '#';
        boolean found = dfs(b, w, i + 1, j, idx + 1) || dfs(b, w, i - 1, j, idx + 1) ||
                dfs(b, w, i, j + 1, idx + 1) || dfs(b, w, i, j - 1, idx + 1);
        b[i][j] = c;
        return found;
    }

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        System.out.println(new WordSearch().exist(board, "ABCCED")); // true
    }
}
