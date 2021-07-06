import java.util.*;

class StarSequence {
    
    public int solution(int[] a) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<a.length; i++) {
            if(map.containsKey(a[i])) {
                map.get(a[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(a[i], list);
            }
        }
        
        int answer = 0;
        for(int key: map.keySet()) {
            int count = 0;
            int end = 0;
            
            List<Integer> list = map.get(key);
            if(list.size() < 2) {
                continue;
            }
            
            for(int i=0; i<list.size(); i++) {
                int curr = list.get(i);
                if(0<=curr-1 && a[curr-1] != key && end<=curr-1) {
                    count += 2;
                    end = curr+1;
                    continue;
                } 
                if(curr+1<a.length && a[curr+1] != key) {
                    count += 2;
                    end = curr+2;
                    continue;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
