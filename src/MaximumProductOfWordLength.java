/**
 * 最大单词长度乘积   使用位运算来记录每个单词包含的字母，使用相与的方式来判断是否有相同字母。
 * user:lufei
 * DATE:2021/11/17
 **/
public class MaximumProductOfWordLength {
    public static int maxProduct(String[] words) {
        int len = words.length;
        int[] mark = new int[len];
        for (int j = 0;j<len;j++) {
            for (int i = 0;i<words[j].length();i++) {
                mark[j] |= 1<<(words[j].charAt(i)-'a');
            }
        }
        int maximum = 0;
        for (int i = 0;i<len;i++) {
            for (int j = i+1;j<len;j++) {
                if ((mark[i]&mark[j])==0) {
                    maximum = Math.max(maximum,words[i].length()*words[j].length());
                }
            }
        }
        return maximum;
    }

    public static void main(String[] args) {
        String[] s = {"abcw","baz","foo","bar","xtfn","abcdef"};
        maxProduct(s);
    }
}
