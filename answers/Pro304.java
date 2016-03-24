public class NumMatrix {
    int[][] sums;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        sums = new int[matrix.length + 1][matrix[0].length + 1];
        sums[1][1] = matrix[0][0];
        for (int row = 1; row < matrix.length; row++) {
            sums[row + 1][1] += sums[row][1] + matrix[row][0];
        }
        for (int col = 1; col < matrix[0].length; col++) {
            sums[1][col + 1] += sums[1][col] + matrix[0][col];
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                sums[row + 1][col + 1] = sums[row][col + 1] + sums[row + 1][col]
                        - sums[row][col] + matrix[row][col];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sums[row2 + 1][col2 + 1] - sums[row2 + 1][col1]
             - sums[row1][col2 + 1] + sums[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);