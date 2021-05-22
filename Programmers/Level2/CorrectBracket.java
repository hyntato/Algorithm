import java.util.*;

class CorrectBracket {
    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
      
        for(int i=0; i<s.length(); i++) {
            char curr = s.charAt(i);
            if(curr == '(')
                stack.push(curr);
            else if(!stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else {
                stack.push(curr);
                break;
            }
        }
        return stack.isEmpty();
    }
}
