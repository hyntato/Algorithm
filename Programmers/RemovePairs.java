import java.util.*;

class RemovePairs {
    public int solution(String s) {
        Stack<Character> stack = new Stack<Character>();
      
        for(char ch: s.toCharArray()) {
            if(stack.isEmpty())
                stack.push(ch);
            else if(stack.peek() == ch)
                stack.pop();
            else
                stack.push(ch);
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
