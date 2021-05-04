import java.util.*;

class GemShopping {
    
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String gem: gems) {
            set.add(gem);
        }
        
        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        
        int min = gems.length;
        int minStart = 0;
        
        while(end < gems.length) {
            // end 조절
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            if(map.size() == set.size()) {
                // start 조절
                while(start <= end) {
                    if(map.get(gems[start]) > 1) {
                        map.put(gems[start], map.get(gems[start]) - 1);
                        start++;
                    }
                    else {
                        break;
                    }
                }
                if(min > end-start) {
                    min = end-start;
                    minStart = start;
                }
            }
            end++;
        }
        
        answer[0] = minStart+1;
        answer[1] = answer[0]+min;
        return answer;
    }
        
}
