import java.util.Map;
import java.util.TreeMap;

/**
 * user:lufei
 * DATE:2021/11/29
 **/
public class kThSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        Map<Double,Integer[]> map = new TreeMap<>();
        for(int i = 0;i<arr.length;i++) {
            for (int j = i+1;j<arr.length;j++) {
                map.put(arr[i]*1.0/arr[j], new Integer[]{arr[i], arr[j]});
            }
        }
        Integer[] val = new Integer[2];
        for (Map.Entry<Double,Integer[]> entry: map.entrySet()) {
            k--;
            if (k==0) {
                val[0] = entry.getValue()[0];
                val[1] = entry.getValue()[1];
                break;
            }
        }
        int[] a = new int[2];
        a[0] = val[0];
        a[1] = val[1];
        return a;
    }

    public static void main(String[] args) {

    }
}
