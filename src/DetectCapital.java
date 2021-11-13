/**检查大写字母
 * user:lufei
 * DATE:2021/11/13
 **/
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        String s = word.toUpperCase();
        String s1 = word.toLowerCase();
        String substring = word.substring(1);
        String s2 = substring.toLowerCase();
        if (word.equals(s)) {
            return true;
        }
        if (word.equals(s1)) {
            return true;
        }
        if (Character.isUpperCase(word.charAt(0))&&substring.equals(s2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Word"));
        System.out.println(detectCapitalUse("WORD"));
        System.out.println(detectCapitalUse("word"));
        System.out.println(detectCapitalUse("WOrd"));
    }
}
