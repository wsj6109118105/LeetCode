import java.util.HashSet;
import java.util.Set;

/** 完美矩形 所有小矩形刚好可以形成一个大矩形，
 * user:lufei
 * DATE:2021/11/16
 **/
public class perfectRectangle {
    public boolean isRectangleCover(int[][] r) {
        // 大矩形的四个点
        int left = Integer.MAX_VALUE;
        int bottom = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int top = Integer.MIN_VALUE;
        // 判断顶点是否只出现一次
        Set<String> set = new HashSet<>();
        int sum = 0;
        // 计算小矩形的面积和
        for (int[] t : r) {
            left = Math.min(t[0],left);
            bottom = Math.min(t[1],bottom);
            right = Math.max(t[2],right);
            top = Math.max(t[3],top);
            sum += Area(t[0],t[1],t[2],t[3]);
            String[] s = new String[4];
            s[0] = merge(t[0],t[1]);
            s[1] = merge(t[0],t[3]);
            s[2] = merge(t[2],t[1]);
            s[3] = merge(t[2],t[3]);
            for (int j = 0;j<4;j++) {
                if (set.contains(s[j]))
                    set.remove(s[j]);
                else
                    set.add(s[j]);
            }
        }

        if (set.size()==4&&set.contains(merge(left,bottom))
        &&set.contains(merge(left,top))&&set.contains(merge(right,bottom))
        &&set.contains(merge(right,top))) {
            return sum==Area(left,bottom,right,top);
        }
        return false;
    }

    private String merge(int i, int i1) {
        return i+" "+i1;
    }

    private int Area(int left, int bottom, int right, int top) {
        return (right-left)*(top-bottom);
    }
}
