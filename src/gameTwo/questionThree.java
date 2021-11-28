package gameTwo;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * user:lufei
 * DATE:2021/11/28
 **/
public class questionThree {
    public static int minimumDeletions(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 1;
        }else if (len ==2 || len == 3) {
            return 2;
        }
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int minIndex = 0;
        int maxIndex = 0;
        for(int i = 0;i<len;i++) {
            if (nums[i]==max) {
                maxIndex = i;
            }
            if (nums[i]==min) {
                minIndex = i;
            }
            if (minIndex!=0&&maxIndex!=0)
                break;
        }
        int[] arr = new int[3];
        arr[0] = Math.max(minIndex,maxIndex)+1;
        arr[1] = len - Math.min(minIndex,maxIndex);
        arr[2] = Math.min(minIndex,maxIndex)+1 + len - Math.max(minIndex,maxIndex);
        return Arrays.stream(arr).min().getAsInt();
    }

    public static void main(String[] args) {
        int[] a = {2,10,7,5,4,1,8,6};
        System.out.println(minimumDeletions(a));
    }
}
