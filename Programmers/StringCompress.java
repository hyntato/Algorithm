class StringCompress {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2; i++) {
            int len = compress(s, i);
            answer = Math.min(answer, len);
        }
        return answer;
    }
    
    public int compress(String s, int unit) {
        int idx = 0;
        String result = "";
        String pre = s.substring(idx, idx+unit);
        int cnt = 1;
        idx += unit;
        
        while(true) {
            // 남은 문자열
            if(idx+unit > s.length()) {
                if(cnt != 1) 
                    result += cnt;
                result += pre;
                result += s.substring(idx);
                break;
            }
            
            String curr = s.substring(idx, idx+unit);
            if(pre.equals(curr))
                cnt++;
            else {
                if(cnt != 1)
                    result += cnt;
                result += pre;
                cnt = 1;
                pre = curr;
            }
            idx += unit;
        }
        return result.length();
    }
}

/* 스택 사용
import java.util.*;

class StringCompress {
    public int solution(String s) {
        int answer = s.length();
        for(int i=1; i<=s.length()/2; i++) {
            Stack<String> strStack = new Stack<>();
            Stack<Integer> cntStack = new Stack<>();
            compress(s, i, strStack, cntStack);
            answer = Math.min(answer, makeString(strStack, cntStack));
        }
        return answer;
    }
    
    public void compress(String s, int unit, Stack<String> strStack, Stack<Integer> cntStack) {
        int idx = 0;
        String curr = "";
        
        for(int i=0; i<s.length()/unit; i++) {
            curr = s.substring(idx, idx+unit);
            if(strStack.isEmpty()) {
                strStack.push(curr);
                cntStack.push(1);
            } else {
                if(strStack.peek().equals(curr))
                    cntStack.push(cntStack.pop()+1);
                else {
                    strStack.push(curr);
                    cntStack.push(1);
                }
            }
            idx += unit;
        }
        
        if(idx == s.length()) return;
        
        // 남은 문자열
        curr = s.substring(idx);
        if(strStack.peek().equals(curr))
            cntStack.push(cntStack.pop()+1);
        else {
            strStack.push(curr);
            cntStack.push(1);
        }
    }
    
    public int makeString(Stack<String> strStack, Stack<Integer> cntStack) {
        int size = strStack.size();
        String str = "";
        
        for(int i=0; i<size; i++) {
            int cnt = cntStack.pop();
            String tmp = "";
            if(cnt != 1)
                tmp = cnt + strStack.pop();
            else
                tmp = strStack.pop();
            str = tmp + str;
        }
        return str.length();
    }
}
*/
