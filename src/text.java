import java.util.*;

/**
 * user:lufei
 * DATE:2022/3/22
 **/
public class text {
    public static void main(String[] args) {
        String As = "1.0.0.0",Ae = "126.255.255.255",
                B = "128.0.0.0",C = "192.0.0.0",
                D = "224.0.0.0",E = "240.0.0.0",
                Y1 = "255.0.0.0",Y2 = "255.255.0.0",
                Y3 = "255.255.255.0";
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        String str = "10.70.44.68~255.254.255.0";
        String[] split = str.split("~");
        System.out.println(split[0]+" " + split[1]);
        List<Integer> list = new ArrayList<>();
    }
}
