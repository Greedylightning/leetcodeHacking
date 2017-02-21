public class Solution{

    public int[][] rotateMatrix(int[][] matrix){

        if(matrix.length == 0 || matrix[0].length() != matrix.length()) return ;
        int n = matrix.length;
        int temp;
        for(int i = 0; i < n / 2; i++){
            for(int j = 0 ; j < n; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        return matrix;
    }
}