import java.util.ArrayDeque;
import java.util.Deque;

/** 边界着色
 * user:lufei
 * DATE:2021/12/7
 **/
public class coloringABorder {
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        int[][] di = {{1,0},{-1,0},{0,1},{0,-1}};
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{row,col});
        while (deque.size()!=0) {
            int[] a = deque.pollFirst();
            int x = a[0], y = a[1];
            int count = 0;
            for (int[] ints : di) {
                int nx = x+ints[0],ny = y+ints[1];
                if(nx<0||nx>=m||ny<0||ny>=n)
                    continue;
                if (grid[nx][ny]!=grid[x][y]) {
                    continue;
                }else {
                    count++;
                }
                if (ans[nx][ny]==0) {
                    deque.addLast(new int[]{nx,ny});
                }
            }
            ans[x][y] = count==4?grid[x][y]:color;
        }
        for (int i = 0;i<m;i++) {
            for (int j = 0;j<n;j++) {
                if (ans[i][j]==0) {
                    ans[i][j] = grid[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,2}};
        int row = 0,col = 0,color = 3;
        colorBorder(grid,row,col,color);
    }
}
