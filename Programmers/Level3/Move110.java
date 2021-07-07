import java.util.*;

class Move110 {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int i=0; i<s.length; i++) {
            Stack<Character> stack = new Stack<>();
            int count = find110(s[i], stack);
            
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb = sb.reverse();
            
            if(sb.toString().equals("1")) {
                while(count>0) {
                    sb.insert(0, "110");
                    count--;
                }
            } else if(sb.indexOf("11") >= 0) { 
                while(count>0) {
                    sb.insert(sb.indexOf("11"), "110");
                    count--;
                }
            } else if(sb.lastIndexOf("0") >= 0) {
                while(count>0) {
                    sb.insert(sb.lastIndexOf("0")+1, "110");
                    count--;
                }
            } else {
                while(count>0) {
                    sb.append("110");
                    count--;
                }
            } 
            answer[i] = sb.toString();
        }
        return answer;
    }
    
    public int find110(String s, Stack<Character> stack) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            stack.push(s.charAt(i));
            
            if(stack.size() >= 3) {
                char ch1 = stack.pop();
                char ch2 = stack.pop();
                char ch3 = stack.pop();
                if(ch1=='0' && ch2=='1' && ch3=='1') {
                    count++;
                } else {
                    stack.push(ch3);
                    stack.push(ch2);
                    stack.push(ch1);
                }
            }
        }
        return count;
    }
}
