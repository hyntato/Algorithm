import java.util.*;

class LZWcompress {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        // 1. init
        for(int i=0; i<26; i++) {
            map.put((char)('A'+i)+"", i+1);
        }
      
        while(true) {
            int idx = 0;
            String word = msg.charAt(idx)+"";
            // 2. w 찾기
            while(idx < msg.length()-1) {
                if(!map.containsKey(word+msg.charAt(++idx))) 
                    break;
                word += msg.charAt(idx);
            }
            // 3. 색인 번호 출력, w 제거
            list.add(map.get(word));
            msg = msg.substring(word.length());
            
            // 4. w+c 등록
            if(msg.length() > 0)
                map.put(word+msg.charAt(0), map.size()+1);
            else
                break;
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
