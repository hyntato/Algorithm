import java.util.*;

class Nesting {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for(char ch: S.toCharArray()) {
            if(ch == '(') {
                stack.push(ch);
            } else if(stack.isEmpty() || stack.pop() != '(') {
                return 0;
            }
        }

        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
