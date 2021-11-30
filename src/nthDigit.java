/** 无限数列，求第 n 位的数字
 * eg: 11
 *  1 2 3 4 5 6 7 8 9 10    第 11 位为 0
 * user:lufei
 * DATE:2021/11/30
 **/
public class nthDigit {
    public static int findNthDigit(int n) {
        int len = 1;
        while(len*9*Math.pow(10,len-1)<n) {
            n-=len*9*Math.pow(10,len-1);
            len++;
        }
        int num = (int) (Math.pow(10,len-1) + n/len);
        int index = n%len;
        if (index==0) {
            return (num-1)%10;
        }else {
            return (int) ((num/Math.pow(10,len-index))%10);
        }
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(11));
    }
}
