/** 连续字符 ， 只包含一种字符的最长非空子字符串的长度    eg: leetcode    ee  2
 * user:lufei
 * DATE:2021/12/1
 **/
public class consecutiveCharacters {
    public static int maxPower(String s) {
        if(s.length()==1) {
            return 1;
        }
        int count = 1,sum = 0;
        for(int i = 0;i<s.length();i++) {
            if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)) {
                count++;
            }else {
                sum = Math.max(sum,count);
                count = 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
    }
}
