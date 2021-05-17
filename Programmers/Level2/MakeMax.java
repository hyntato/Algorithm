import java.util.*;

class MakeMax {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<number.length(); i++) {
            while(true) {
                if(!stack.isEmpty() && stack.peek() < number.charAt(i) && k > 0) {
                    stack.pop();
                    k--;
                }
                else break;
            }
            stack.push(number.charAt(i));
        }
        
        String answer = "";
        for(int i=0; i<stack.size()-k; i++) {
            answer += stack.get(i);
        }
        return answer;
    }
}
