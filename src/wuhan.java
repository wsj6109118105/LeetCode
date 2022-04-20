/**
 * user:lufei
 * DATE:2022/4/5
 **/
public class wuhan {
    public static void main(String[] args) {
        double high = 100;
        double sum = 0;
        for(int i = 0;i<10;i++) {
            sum+=high;
            high/=2;
        }
        System.out.println(sum);
        System.out.println(high);
    }
}
