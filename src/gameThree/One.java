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
        int[] a = new int[10];
        for(int i = 0;i<digits.length;i++) {
            a[digits[i]]++;
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 100;i<1000;i+=2) {
            int three = i%10;
            int two = i/10%10;
            int one = i/100;
            a[one]--;
            a[two]--;
            a[three]--;
            if(a[one]>=0&&a[two]>=0&&a[three]>=0) {
                list.add(i);
            }
            a[one]++;
            a[two]++;
            a[three]++;
        }
        int[] arr = new int[list.size()];
        for(int i = 0;i<list.size();i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
