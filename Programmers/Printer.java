import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 또는 큐로 구현
        List<Integer> documents = new ArrayList<>();
        for(int i=0; i<priorities.length; i++) {
            documents.add(priorities[i]);
        }
        
        Arrays.sort(priorities);
        
        int idx = priorities.length-1;
        int cnt = 0;
        
        while(documents.size() > 0) {
            int doc = documents.remove(0);
            location--;
            
            // 맨 뒤로 이동
            if(doc < priorities[idx]) {
                documents.add(doc);
                if(location < 0) {
                    location = documents.size() - 1;
                }
            }
            // 인쇄
            else {
                cnt++;
                idx--;
                if(location < 0) {
                    break;
                }
            }
        }
        return cnt;
    }
}

/*
중요도가 높은 문서 먼저 인쇄

매번 뒤의 문서들과 비교하는 건 비효율적! > 중요도 sort, 이것과 비교
문서 순서 유지하면서 비교
location > 맨 뒤로 갈때 변경
*/
