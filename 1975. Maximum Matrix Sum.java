class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                sum += Math.abs(matrix[i][j]);
                if(matrix[i][j] < 0){
                    count++;
                }
                min = Math.min(min, Math.abs(matrix[i][j]));
            }
        }
        if(count % 2 == 0){
            return sum;
        }
        return sum - 2 * min;
    }
}