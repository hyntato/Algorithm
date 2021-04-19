import java.util.*;

class JoyStick {
    public int solution(String name) {
        int len = name.length();
        int count = 0;
        int move = len-1;
        
        for(int i=0; i<len; i++) {
            // 알파벳 변환 횟수
            count += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
            
            // 커서 이동 횟수
            int next = i+1;
            while(next < len && name.charAt(next) == 'A') {
                next++;
            }
            move = Math.min(move, i + i+len-next);
        }
        count += move;
        
        return count;
    }
}
