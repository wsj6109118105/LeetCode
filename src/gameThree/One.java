package gameThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * user:lufei
 * DATE:2021/12/5
 **/
public class One {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<digits.length;i++) {
            if(digits[i]==0) {
                continue;
            }
            for(int j = 0;j<digits.length;j++) {
                if(j==i) {
                    continue;
                }
                for(int k = 0;k<digits.length;k++) {
                    if(k==i||k==j) {
                        continue;
                    }
                    if(digits[k]%2!=0) {
                        continue;
                    }
                    if(!list.contains(digits[i]*100+digits[j]*10+digits[k]))
                        list.add(digits[i]*100+digits[j]*10+digits[k]);
                }
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0;i<list.size();i++) {
            a[i] = list.get(i);
        }
        Arrays.sort(a);
        return a;
    }
}
