/** 灯泡亮灭。
 * user:lufei
 * DATE:2021/11/15
 **/
public class bulbSwitcher {
    public static int bulbSwitch(int n) {
        return (int) Math.sqrt(n+0.5);
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(4));
    }
}
