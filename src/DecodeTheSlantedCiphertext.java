/** 解码斜向换位密码，     今天参加周赛，又被虐了一顿。。。。
 * user:lufei
 * DATE:2021/11/14
 **/
public class DecodeTheSlantedCiphertext {
    public static String decodeCiphertext(String encodedText, int rows) {
        if(rows == 1) {
            return encodedText;
        }
        if(encodedText.equals("")) {
            return encodedText;
        }
        int len = encodedText.length();
        int rowLen = len/rows;
        String[] s = new String[rows];
        for(int i=0;i<rows;i++){
            s[i] = encodedText.substring(i*rowLen,((i+1)*rowLen));
        }
        int count = 0;
        StringBuilder encode = new StringBuilder();    // 此处不能适用String 会超出时间限制
        while (count<rowLen) {
            int k = count;
            for (int i=0;i<rows;i++) {
                encode.append(s[i].charAt(k++));
                if (k>=rowLen) {
                    break;
                }
            }
            count++;
        }
        int last = 0;
        for (int i = encode.length()-1;i>=0;i--) {
            if (encode.charAt(i)!=' ') {
                last = i+1;
                break;
            }
        }
        return encode.substring(0,last);
    }

    public static void main(String[] args) {
        System.out.println(decodeCiphertext("a  b  ", 3));
    }
}
