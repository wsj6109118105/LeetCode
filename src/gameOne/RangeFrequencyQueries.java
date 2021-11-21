package gameOne;

import java.util.HashMap;
import java.util.Map;

/** 区间内查询数字的频率   加入 map 作为缓存，防止超时
 * user:lufei
 * DATE:2021/11/21
 **/
public class RangeFrequencyQueries {
    private int[] arr;
    private Map<String,Integer> map = new HashMap<>();

    public RangeFrequencyQueries(int[] arr) {
        this.arr = arr;
    }

    public int query(int left, int right, int value) {
        String s = left +"," +right +"," +value;
        if(map.get(s)!=null)
            return map.get(s);
        else {
            int A = 0;
            for(int i = left;i<=right;i++) {
                if(arr[i]==value)
                    A++;
            }
            map.put(s,A);
            return A;
        }
    }
}
