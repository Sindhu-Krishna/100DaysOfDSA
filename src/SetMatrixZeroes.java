public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0)
                firstCol = true;
        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0)
                firstRow = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (firstCol)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
        if (firstRow)
            for (int j = 0; j < n; j++)
                matrix[0][j] = 0;
    }

    // Helper function to print matrix
    public void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        SetMatrixZeroes obj = new SetMatrixZeroes();
        obj.setZeroes(mat);

        System.out.println("Final Matrix:");
        obj.printMatrix(mat);
    }
}
