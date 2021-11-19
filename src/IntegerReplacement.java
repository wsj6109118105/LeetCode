/** 整数替换   使用位运算来计算，如果可以连续消除多个 1，那么加1，否则减 1 ， 转换为 long 类型，否则示例会益处
 * user:lufei
 * DATE:2021/11/19
 **/
public class IntegerReplacement {
    public static int integerReplacement(int n) {
        long s = n;
        int count = 0;
        while (s!=1) {
            if ((s&1)==0) {
                s >>= 1;
            }else {
                if ( s != 3 && ((s>>1) & 1) == 1) s++;
                else s--;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(integerReplacement(2147483647));
    }
}
