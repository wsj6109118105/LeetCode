import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * user:lufei
 * DATE:2021/12/2
 **/
public class relativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        int[] arr = Arrays.copyOf(score,score.length);
        Map<Integer,String> map = new HashMap<>();
        Arrays.sort(arr);
        for(int i = 0;i<arr.length;i++) {
            if(i== arr.length-1) {
                map.put(arr[i],"Gold Medal");
            }else if(i==arr.length-2) {
                map.put(arr[i],"Silver Medal");
            }else if(i== arr.length-3) {
                map.put(arr[i],"Bronze Medal");
            }else{
                map.put(arr[i],arr.length-i+"");
            }
        }
        String[] s = new String[score.length];
        for(int i = 0;i<s.length;i++) {
            s[i] = map.get(score[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] a = {5,4,3,2,1};
        findRelativeRanks(a);
    }
}
