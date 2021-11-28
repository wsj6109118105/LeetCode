package gameTwo;

import java.util.Arrays;

/**
 * user:lufei
 * DATE:2021/11/28
 **/
public class questionTwo {
    public static int[] getAverages(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        if(len<2*k+1){
            Arrays.fill(arr,-1);
        }
        long count = 0;
        for(int i = 0;i<len;i++) {
            if(i+k<len&&i-k>=0) {
                if (i-k==0) {
                    for(int j = i-k;j<=i+k;j++) {
                        count += nums[j];
                    }
                }else {
                    count = count - nums[i-k-1] +nums[i+k];
                }
                arr[i] = ((int)count)/(2*k+1);
            }else {
                arr[i] = -1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {7,4,3,9,1,8,5,2,6};
        getAverages(nums,3);
        long a = 37;
        System.out.println((int)a/7);
    }
}
