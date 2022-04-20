import java.util.Stack;

/**
 * user:lufei
 * DATE:2022/3/20
 **/
public class ThreeTwoZero {
    public static int countCollisions(String directions) {
        Stack<Character> deque = new Stack<>();
        int len = directions.length(),count = 0;
        for(int i = 0;i<len;i++) {
            if(directions.charAt(i)=='L') {
                if(!deque.empty()) {
                    if(deque.peek()=='R') {
                        deque.pop();
                        count += 2;
                        while(!deque.empty()) {
                            if(deque.peek()=='R') {
                                deque.pop();
                                count++;
                            }else {
                                break;
                            }
                        }
                        deque.push('S');
                    }else if(deque.peek()=='S'){
                        deque.pop();
                        count += 1;
                        deque.push('S');
                    }
                }
            }else if(directions.charAt(i)=='R') {
                deque.push('R');
            }else if(directions.charAt(i)=='S') {
                while(!deque.empty()) {
                    if(deque.peek()=='R') {
                        deque.pop();
                        count++;
                    }else {
                        break;
                    }
                }
                deque.push('S');
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
