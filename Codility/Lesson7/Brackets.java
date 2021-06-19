import java.util.*;

class Brackets {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        
        for(char ch: S.toCharArray()) {
            switch(ch) {
                case '(': case '[': case '{':
                stack.push(ch); break;
                case ')':
                if(stack.isEmpty() || stack.pop() != '(') {
                    return 0;
                }
                break;
                case ']':
                if(stack.isEmpty() || stack.pop() != '[') {
                    return 0;
                }
                break;
                case '}':
                if(stack.isEmpty() || stack.pop() != '{') {
                    return 0;
                }
                break;
            }
        }
        if(stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
