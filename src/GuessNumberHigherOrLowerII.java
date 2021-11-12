/**
 * user:lufei
 * DATE:2021/11/12
 **/

/**
 * f[i][j] 表示从 (i,j)的最大的花费  那么 (1,n) 的最大花费即为 f[1][n],
 * 在 (1,n) 中任意选一个数 k , 那么此时分为 3个部分, 1-(k-1),k,(k+1)-n
 * 如果选择出错那么需要付出 k, 然后再从 1-(k-1)或(k+1)-n 两个区间进行选择
 * 因为需要知道至少需要多少钱,所以应当取两个中较大的那个,由子区间的花费情况
 * 来得到当前区间花费情况,每个区间通过枚举 k的位置,来得到每个区间的最小花费
 * 最终求得 (1,n) 至少需要多少花费。
 */
public class GuessNumberHigherOrLowerII {
    public static int getMoneyAmount(int n) {
        int[][] f = new int[n+1][n+1];
        // 区间应从后往前
        for (int i = n-1;i>=1;i--) {
            for (int j = i+1;j<=n;j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i;k<j;k++) {
                    // 当从前往后时无法得到 f[k+1][j]
                    int cost = k + Math.max(f[i][k-1],f[k+1][j]);
                    min = Math.min(min,cost);
                }
                f[i][j] = min;
            }
        }
        System.out.println(f[1][n]);
        return f[1][n];
    }

    public static void main(String[] args) {
        getMoneyAmount(10);
    }
}
