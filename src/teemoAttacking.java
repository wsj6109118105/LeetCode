/**
 * 提莫攻击  简单
 * user:lufei
 * DATE:2021/11/10
 **/
public class teemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // 记录没两次攻击之间中毒时间，加上最后一个时长。
        int len = timeSeries.length;
        int t = 0;
        for(int i=0;i<len-1;i++) {
            t += Math.min(timeSeries[i+1],timeSeries[i]+duration)-duration;
        }
        return t+duration;
    }
}
