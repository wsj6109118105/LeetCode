package gameOne;

/** k镜像数字的和   在 10 进制和 k 进制下正反一样的数为 k镜像数字
 * 通过枚举十进制下的镜像数字来实现，
 * 具体先枚举前半部分，在复制后半部分
 * 当长度为偶数时，前后部分长度各一半
 * 当长度为奇数时，后半部分长度比前半部分少 1
 * 所以确定前半部分范围，再将前半部分倒置形成后半部分
 * 最后转化为 k 进制数查看是否为镜像数
 * user:lufei
 * DATE:2021/11/21
 **/
public class sumOfKmirrorNumbers {
    private static boolean isGood(char[] c) {
        for (int i = 0, j = c.length - 1; i < j; i++, j--) {
            if (c[i] != c[j]) {
                return false;
            }
        }
        return true;
    }

    public static long kMirror(int k, int n) {
        long ans = 0;
        for (int len = 1; ; len++) {
            int x = (int) Math.pow(10, (len - 1) / 2);
            int y = (int) Math.pow(10, (len + 1) / 2);
            for (int i = x; i < y; i++) {
                long nn = i;
                for (int j = len % 2 == 0 ? i : i / 10; j > 0; j /= 10) {
                    nn = nn * 10 + j % 10;
                }
                String ss = Long.toString(nn, k);
                if (isGood(ss.toCharArray())) {
                    ans += nn;
                    if (--n == 0) {
                        return ans;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(kMirror(3, 30));
    }
}
