public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix[0].length ; i ++){
            for (int j = 0 ; j < matrix.length ; j ++){
                if (i == 0){
                    // sum[i][j] = matrix[i][j];
                    sum[j][i] = matrix[j][i];
                }
                else{
                    // sum[i][j] = sum[i - 1][j] + matrix[i][j];
                    sum[j][i] = sum[j][i-1] + matrix[j][i];
                }
            }
        }
        
        int max = Integer.MIN_VALUE;
        for (int i = 0 ; i < matrix[0].length ; i ++){
            for (int j = i ; j < matrix[0].length ; j ++){
                TreeSet<Integer> treeSet = new TreeSet<Integer>();
                int totalSum = 0;
                for (int l = 0 ; l < matrix.length ; l ++){
                    
                    totalSum += sum[l][j] - ((i != 0) ? sum[l][i - 1] : 0);
                    // totalSum += sum[j][l] - ((i != 0) ? sum[i - 1][l] : 0);
                    if (totalSum <= k){
                        max = Math.max(totalSum, max);
                    }
                    Integer smaller = treeSet.ceiling(totalSum - k);
                    if (smaller != null){
                        max = Math.max(max, totalSum - smaller);
                    }
                    treeSet.add(totalSum);
                }
            }
        }
        
        return max;
    }
}