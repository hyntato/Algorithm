import java.util.*;

class BracketConversion {
    public String solution(String p) {
        if(p.length() == 0) return p;
            
        String[] split = splitBalancedStr(p);
        String u = split[0];
        String v = split[1];
            
        if(isRight(u)) {
            return u + solution(v);
        } else {
            String tmp = "(";
            tmp += solution(v);
            tmp += ")";
            tmp += flip(u.substring(1, u.length()-1));
            return tmp;
        }
    }
    
    public String[] splitBalancedStr(String str) {
        String[] split = new String[2];
        int sNum = 0;
        int eNum = 0;
        for(char ch: str.toCharArray()) {
            if(ch == '(') sNum++;
            else eNum++;
            
            if(sNum == eNum) {
                split[0] = str.substring(0, sNum+eNum);
                split[1] = str.substring(sNum+eNum);
                break;
            }
        }
        return split;
    }
    
    public boolean isRight(String str) {
        Stack<Character> stack = new Stack<>();
        for(char ch: str.toCharArray()) {
            if(ch == '(')
                stack.push(ch);
            else if(!stack.isEmpty() && stack.peek() == '(')
                stack.pop();
        }
        return stack.isEmpty();
    }
    
    public String flip(String str) {
        String result = "";
        for(char ch: str.toCharArray()) {
            if(ch == '(')
                result += ')';
            else
                result += '(';
        }
        return result;
    }
}
