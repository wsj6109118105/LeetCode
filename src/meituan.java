import java.lang.reflect.Array;
import java.util.*;

/**
 * user:lufei
 * DATE:2022/3/26
 **/
public class meituan {
    // acbcca
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int numA = 0;
        int numB = 0;
        int numC = 0;
        for(int i = 0;i<str.length();i++) {
            if(str.charAt(i)=='a') {
                numA++;
            }else if(str.charAt(i)=='b') {
                numB++;
            }else if(str.charAt(i)=='c') {
                numC++;
            }
        }
        int countA = numA-1;
        int countB = numB;
        int countC = numC/3;
        int count = Math.min(countA,Math.min(countB,countC));
        System.out.println(count);
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        if(arr[n-1]==arr[0]) {
            System.out.println(0);
        }
        int minval = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++) {
            int a = Math.abs(arr[n-1]-arr[i]);
            int b = Math.abs(arr[0]-arr[i]);
            if(Math.abs(a-b)<=minval) {
                minval = Math.abs(a-b);
            }
        }
        System.out.println(minval);
    }*/

    /*static int maxval = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        help(arr,0,0);
        System.out.println(maxval);
    }

    public static void help(int[] arr,int pos,int val) {
        if(pos==arr.length) {
            if(val%7==0&&val>maxval) {
                maxval = val;
            }
            return;
        }
        help(arr,pos+1,val+arr[pos]);
        help(arr,pos+1,val);
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        int sum = 0;
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        Arrays.sort(arr);
        int count = sum;
        int left = 0,right = n-1;
        while(right-left>=2) {
            count = count - arr[left] - arr[right];
            sum += count;
            left++;
            right--;
        }
        System.out.println(sum);
    }*/

    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr= new int[n];
        int sum = 0;
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
            sum+=arr[i];
        }
        for(int i = 3;i<n;i+=2) {
            for(int j = 0;j<=n-i;j++) {
                //int[] ints = Arrays.copyOfRange(arr, j, j + i);
                    //Arrays.sort(ints);
                Arrays.sort(arr,j,j+i);
                    sum+=arr[(j+j+i)/2];

            }
        }
        System.out.println(sum);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a,b)->a.get(1)-b.get(1));
        for(int i = 0;i<n;i++) {
            List<Integer> list = new ArrayList<>();
            int L = in.nextInt();
            int C = in.nextInt();
            list.add(L);
            list.add(C);
            while(C>0) {
                int a = in.nextInt();
                list.add(a);
                C--;
            }
            queue.offer(list);
        }
        int[] arr = new int[n];
        while(!queue.isEmpty()) {
            List<Integer> list = queue.poll();
            if(list.get(1)==0) {

            }
        }
        for(int i = 0;i<n;i++) {
            System.out.println(arr[i]);
        }
    }
}
