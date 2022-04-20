package reflect;

import java.lang.reflect.Method;
import java.util.*;

/**
 * user:lufei
 * DATE:2022/4/9
 **/
public class client {

    public static void main(String[] args) {
        int[][] arr ={{4,3,2},{7,6,1},{8,8,8}};
        int i = maxTrailingZeros(arr);
        System.out.println(i);
    }

    public static int maxTrailingZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] down = new int[m][n];
        int[][] left = new int[m][n];
        int[][] right = new int[m][n];
        int[][] up = new int[m][n];
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                down[i][j] = 1;
                left[i][j] = 1;
                right[i][j] = 1;
                up[i][j] = 1;
            }
        }
        //down
        for(int j = 0;j<n;j++) {
            for(int i = 0;i<m;i++) {
                if(i>0)
                    down[i][j] = down[i][j]*down[i-1][j]*grid[i][j];
                else
                    down[i][j] = down[i][j] * grid[i][j];
            }
        }
        //left
        for(int i = 0;i<m;i++) {
            for(int j = n-1;j>=0;j--) {
                if(j<n-1)
                    left[i][j] = left[i][j]*left[i][j+1]*grid[i][j];
                else
                    left[i][j] = left[i][j] * grid[i][j];
            }
        }
        // right
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(j>0)
                    right[i][j] = right[i][j]*right[i][j-1]*grid[i][j];
                else
                    right[i][j] = right[i][j] * grid[i][j];
            }
        }
        // up
        for(int j = 0;j<n;j++) {
            for(int i = m-1;i>=0;i--) {
                if(i<m-1)
                    up[i][j] = up[i][j]*up[i+1][j]*grid[i][j];
                else
                    up[i][j] = up[i][j] * grid[i][j];
            }
        }
        int count = 0;
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                int num1 = 0;
                int val1 = down[i][j] * right[i][j] /grid[i][j];
                while(val1%10==0) {
                    num1++;
                    val1/=10;
                }
                int num2 = 0;
                int val2 = down[i][j] * left[i][j] /grid[i][j];
                while(val2%10==0) {
                    num2++;
                    val2/=10;
                }
                int num = Math.max(num1,num2);
                count = Math.max(count,num);
            }
        }
        for(int i = 0;i<m;i++) {
            for(int j = 0;j<n;j++) {
                int num1 = 0;
                int val1 = up[i][j] * right[i][j] /grid[i][j];
                while(val1%10==0) {
                    num1++;
                    val1/=10;
                }
                int num2 = 0;
                int val2 = up[i][j] * left[i][j] /grid[i][j];
                while(val2%10==0) {
                    num2++;
                    val2/=10;
                }
                int num = Math.max(num1,num2);
                count = Math.max(count,num);
            }
        }
        return count;
    }

    public int maxTrailingZeros1(int[][] grid) {
        int dp1[][][] = new int[grid.length + 1][grid[0].length + 1][2],
                dp2[][][] = new int[grid.length + 1][grid[0].length + 1][2], max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                dp1[i + 1][j + 1] = new int[] { dp1[i][j + 1][0], dp1[i][j + 1][1] };
                dp2[i + 1][j + 1] = new int[] { dp2[i + 1][j][0], dp2[i + 1][j][1] };
                for (; grid[i][j] % 2 == 0; grid[i][j] /= 2) {
                    dp1[i + 1][j + 1][0]++;
                    dp2[i + 1][j + 1][0]++;
                }
                for (; grid[i][j] % 5 == 0; grid[i][j] /= 5) {
                    dp1[i + 1][j + 1][1]++;
                    dp2[i + 1][j + 1][1]++;
                }
            }
        }
        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                max = Math.max(max,
                        Math.max(Math.min(dp1[i][j][0] + dp2[i][j - 1][0], dp1[i][j][1] + dp2[i][j - 1][1]),
                                Math.max(
                                        Math.min(dp1[i][j][0] + dp2[i][grid[0].length][0] - dp2[i][j][0],
                                                dp1[i][j][1] + dp2[i][grid[0].length][1] - dp2[i][j][1]),
                                        Math.max(
                                                Math.min(dp1[grid.length][j][0] - dp1[i][j][0] + dp2[i][j][0],
                                                        dp1[grid.length][j][1] - dp1[i][j][1] + dp2[i][j][1]),
                                                Math.min(
                                                        dp1[grid.length][j][0] - dp1[i][j][0]
                                                                + dp2[i][grid[0].length][0] - dp2[i][j - 1][0],
                                                        dp1[grid.length][j][1] - dp1[i][j][1]
                                                                + dp2[i][grid[0].length][1] - dp2[i][j - 1][1])))));
            }
        }
        return max;
    }
}
