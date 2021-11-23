import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 亲密字符串
 * user:lufei
 * DATE:2021/11/23
 **/
public class buddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if(s.length()!=goal.length()||s.length()==0||goal.length()==0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)!=goal.charAt(i)) {
                list.add(i);
            }
        }
        if (list.size()==0) {
            Set<Character> set = new HashSet<>();
            for (int i = 0;i<s.length();i++) {
                if (set.contains(s.charAt(i))) {
                    return true;
                }else {
                    set.add(s.charAt(i));
                }
            }
            return false;
        }
        if(list.size()!=2) {
            return false;
        }
        if((s.charAt(list.get(0))==goal.charAt(list.get(1)))&&(s.charAt(list.get(1))==goal.charAt(list.get(0))))
            return true;
        return false;
    }
}
