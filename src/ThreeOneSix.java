import java.util.Arrays;

/**
 * user:lufei
 * DATE:2022/3/16
 **/
public class ThreeOneSix {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] arr = new int[m+1][n+1];
        for(int[] i : arr) {
            Arrays.fill(i,0);
        }
        if(m==0||n==0) {
            return 0;
        }
        int max_size = -1;
        for(int i = 1;i <= m;i++) {
            for(int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1]=='1'){
                    arr[i][j] = Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1])) + 1;
                }
                max_size = Math.max(arr[i][j],max_size);
            }
        }
        return max_size*max_size;
    }

    public static void main(String[] args) {
        char[][] arr = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};

        maximalSquare(arr);
    }
}
