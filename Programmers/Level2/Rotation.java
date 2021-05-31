import java.util.*;

class Rotation {
    private List<String> correct = new ArrayList<String>();
    private List<Character> start = new ArrayList<Character>();
    
    public int solution(String s) {
        if(s.length() == 1) return 0;
        
        init();
        
        int answer = 0;
        for(int i=0; i<s.length(); i++) {
            String rotation = s.substring(i) + s.substring(0, i);
            if(isRightBracket(rotation)) {
                answer++;
            }
        }
        return answer;
    }
    
    public boolean isRightBracket(String rotation) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i=0; i<rotation.length(); i++) {
            char ch = rotation.charAt(i);
            
            if(start.contains(ch) || stack.isEmpty())
                stack.push(ch);
            else if(!stack.isEmpty() && !correct.contains(stack.pop() + "" + ch)) 
                return false;
        }
        return stack.isEmpty();
    }
    
    public void init() {
        correct.add("()");
        correct.add("[]");
        correct.add("{}");
        
        start.add('(');
        start.add('[');
        start.add('{');
    }
}
