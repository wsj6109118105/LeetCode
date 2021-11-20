import java.util.HashMap;
import java.util.Map;

/** 最长和谐子序列     记录每个数出现的次数，然后枚举每个 key, 计算 key + (key+1)
 * user:lufei
 * DATE:2021/11/20
 **/
public class longestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int count = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key+1)) {
                count = Math.max(map.get(key)+map.get(key+1),count);
            }
        }
        return count;
    }
}
