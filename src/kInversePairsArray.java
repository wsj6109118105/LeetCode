/** k 个逆序对数组
 * user:lufei
 * DATE:2021/11/11
 **/

/** f[i][j] 为 1-i 有 j 个逆序对的个数。
 * 共有 1-i 个数。
 * 选取 k 放置在末尾，前 i-1 个数为 1 - k-1,k+1 - i
 * k 产生的逆序有 k+1 - i,共 i-k 个，那么前 i-1 个数需要的逆序对为 j-(i-k)个 =====>
 * k ∈ [1,i] , f[i][j] = Σ f[i-1][j-(i-k)]===> k ∈ [0,i-1] , f[i][j] = Σ f[i-1][j-k]
 * f[0][0]=1,空数组 0个逆序为 1, f[i][j<0] = 0,逆序最少为 0.
 *
 * f[i][j-1] = Σ f[i-1][j-k-1)] , k ∈ [0,i-1]
 *
 * f[i][j] = f[i][j-1] + f[i-1][j] - f[i-1][j-1]
 * 可以看到只涉及了  f[i][..] 与 f[i-1][..] 两个数组，可以用两个一维数组交替保存
 */
public class kInversePairsArray {
    public int kInversePairs(int n, int k) {
        final int MOD = 1000000007;
        // 定义两个一维数组
        int[][] f = new int[2][k + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= k; ++j) {
                // 通过位运算决定当前应当存储到哪个数组中
                int cur = i & 1, prev = cur ^ 1;
                // 运算时加入判断 j >=0
                f[cur][j] = (j - 1 >= 0 ? f[cur][j - 1] : 0) - (j - i >= 0 ? f[prev][j - i] : 0) + f[prev][j];
                if (f[cur][j] >= MOD) {
                    f[cur][j] -= MOD;
                } else if (f[cur][j] < 0) {
                    f[cur][j] += MOD;
                }
            }
        }
        return f[n & 1][k];
    }
}
