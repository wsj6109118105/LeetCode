import java.util.HashMap;
import java.util.Map;

/** 选取时选取单词里只出现一次的字母为代表，
 * user:lufei
 * DATE:2021/11/24
 **/
public class reconstructOriginalDigitsFromEnglish {
    public static String originalDigits(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int[] arr = new int[10];
        arr[2] = map.getOrDefault('w',0);
        arr[4] = map.getOrDefault('u',0);
        arr[6] = map.getOrDefault('x',0);
        arr[8] = map.getOrDefault('g',0);
        arr[0] = map.getOrDefault('z',0);
        arr[3] = map.getOrDefault('h',0) - arr[8];
        arr[5] = map.getOrDefault('f',0) - arr[4];
        arr[7] = map.getOrDefault('s',0) - arr[6];
        arr[1] = map.getOrDefault('o',0) - arr[2] - arr[4] - arr[0];
        arr[9] = map.getOrDefault('i',0) - arr[5] -arr[6] - arr[8];
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<10;i++) {
            for(int j=1;j<=arr[i];j++) {
                sb.append(i+"");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(originalDigits("nnei"));
    }
}
