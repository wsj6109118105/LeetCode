package gameOne;

import java.util.Arrays;

/** 两栋颜色不同且距离最远的房子   从前向后找，每次找到需要设置两个位置的信息，因为后面的房子并不会向前看
 * user:lufei
 * DATE:2021/11/21
 **/
public class TwoFurthestHousesWithDifferentColors {
    public int maxDistance(int[] colors) {
        int len = colors.length;
        int[] p = new int[len];
        for(int i = 0;i<len-1;i++) {
            for(int j = i+1;j<len;j++) {
                if(colors[i]!=colors[j]) {
                    p[i] = Math.max(p[i],j-i);
                    p[j] = Math.max(p[j],j-i);
                }
            }
        }
        return Arrays.stream(p).max().getAsInt();
    }
}
