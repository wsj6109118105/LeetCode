import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/11/28
 **/
public class findAllAnagramsInAString {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length()<p.length()) {
            return list;
        }
        int len = p.length();
        char[] pp = p.toCharArray();
        Arrays.sort(pp);
        for (int i = 0;i<=s.length()-len;i++) {
            String str = s.substring(i,i+len);
            char[] c = str.toCharArray();
            Arrays.sort(c);
            if (Arrays.equals(pp,c)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd","abc");
    }
}
