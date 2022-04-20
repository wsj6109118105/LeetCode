/**
 * user:lufei
 * DATE:2022/3/22
 **/
public class ThreeTwoTwo {
    public static boolean winnerOfGame(String colors) {
        boolean flagA1 = false,flagB1 = false,flagA2 = false,flagB2 = false;
        int countA = 0,countB = 0;
        for(int i = 0;i<colors.length();i++) {
            if(flagA2&&flagA1&&colors.charAt(i)=='A') {
                countA++;
            }else if(flagB2&&flagB1&&colors.charAt(i)=='B') {
                countB++;
            }else if(flagA1&&colors.charAt(i)=='A') {
                flagA2 = true;
            }else if(flagB1&&colors.charAt(i)=='B'){
                flagB2 = true;
            }else if(colors.charAt(i)=='A'){
                flagA1 = true;
                flagB1 = false;
                flagB2 = false;
            }else {
                flagA1 = false;
                flagA2 = false;
                flagB1 = true;
            }
        }
        return countA>countB;
    }

    public static void main(String[] args) {
        System.out.println(winnerOfGame("BBAAABBABBABB"));
    }
}
