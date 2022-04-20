import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * user:lufei
 * DATE:2022/4/14
 **/
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int num1 = 0,num2 = 0;
        for(int i = 0 ; i < s.length();i++) {
            if(s.charAt(i)=='1') {
                num1++;
            }else {
                num2++;
            }
        }
        int count = 0;
        if(num1>num2) {
            int OtoZ = 0;
            int ZtoO = 0;
            for(int i = 0;i<s.length();i++) {
                if((i&1)==0) {
                    if(s.charAt(i)!='1') {
                        if(ZtoO>0) {
                            ZtoO--;
                        }else {
                            count++;
                            OtoZ++;
                        }
                    }
                }else {
                    if(s.charAt(i)!='0') {
                        if (OtoZ>0) {
                            OtoZ--;
                        }else {
                            count++;
                            ZtoO++;
                        }
                    }
                }
            }
        }else if(num2>num1) {
            int OtoZ = 0;
            int ZtoO = 0;
            for(int i = 0;i<s.length();i++) {
                if((i&1)!=0) {
                    if(s.charAt(i)!='1') {
                        if(ZtoO>0) {
                            ZtoO--;
                        }else {
                            count++;
                            OtoZ++;
                        }
                    }
                }else {
                    if(s.charAt(i)!='0') {
                        if (OtoZ>0) {
                            OtoZ--;
                        }else {
                            count++;
                            ZtoO++;
                        }
                    }
                }
            }
        }else {
            int count1 = 0,count2 = 0;
            int OtoZ = 0;
            int ZtoO = 0;
            for(int i = 0;i<s.length();i++) {
                if((i&1)==0) {
                    if(s.charAt(i)!='1') {
                        if(ZtoO>0) {
                            ZtoO--;
                        }else {
                            count1++;
                            OtoZ++;
                        }
                    }
                }else {
                    if(s.charAt(i)!='0') {
                        if (OtoZ>0) {
                            OtoZ--;
                        }else {
                            count1++;
                            ZtoO++;
                        }
                    }
                }
            }
            OtoZ = 0;
            ZtoO = 0;
            for(int i = 0;i<s.length();i++) {
                if((i&1)!=0) {
                    if(s.charAt(i)!='1') {
                        if(ZtoO>0) {
                            ZtoO--;
                        }else {
                            count2++;
                            OtoZ++;
                        }
                    }
                }else {
                    if(s.charAt(i)!='0') {
                        if (OtoZ>0) {
                            OtoZ--;
                        }else {
                            count2++;
                            ZtoO++;
                        }
                    }
                }
            }
            count = Math.min(count1,count2);
        }
        System.out.println(count);
    }







    /*static int count;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int len = s.length();
        String des = "";
        char[] ch = new char[len];
        Arrays.fill(ch,'*');
        check(ch,0,len,s);
        System.out.println(count);
    }

    public static void check(char[] s,int pos,int len,String ori) {
        if(pos==len) {
            String q = "";
            for(char c : s) {
                if(c!='*')
                    q+=c;
            }
            if(Objects.equals(q, "")) {
                return;
            }
            BigInteger bigInteger = new BigInteger(q);
            BigInteger divide = bigInteger.mod(new BigInteger("9"));
            boolean equals = divide.equals(new BigInteger("0"));
            if(equals) {
                count ++;
                count%=1000000007;
            }
            return;
        }

        s[pos] = ori.charAt(pos);
        check(s,pos+1,len,ori);
        s[pos] = '*';
        check(s,pos+1,len,ori);
    }*/


    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s1 = "";
        for(int i = 0;i<n;i++) {
            s1+="*";
        }
        String s2 = "";
        for(int i = 0;i<2*n;i++) {
            s2+=".";
        }
        String[] s3 = new String[n];
        s3[0] = ".";
        for(int i = 1;i<n;i++) {
            s3[i] = s3[i-1] + ".";
        }
        for(int i = 0;i<3*n;i++) {
            System.out.println(s1+s2+s1);
        }
        for(int i = 0;i<n-1;i++) {
            System.out.println(s3[i]+s1+s3[n-1-i-1]+s3[n-1-i-1]+s1+s3[i]);
        }
        System.out.println(s3[n-1]+s1+s1+s3[n-1]);
    }*/

    /*public static void main(String[] args) {
        Map<Integer,Integer> red = new HashMap<>();
        //Map<Integer,Integer> blue = new HashMap<>();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        String s = in.next();

        for(int i = 0;i<n;i++) {
            if(s.charAt(i)=='R') {
                red.put(arr[i],red.getOrDefault(arr[i],0)+1);
            }
        }

        int count = 0;
        for(int i = 0;i<n;i++) {
            if(s.charAt(i)=='B'&&red.containsKey(arr[i])) {
                count+=red.get(arr[i]);
            }
        }
        System.out.println(count);
    }*/
}
