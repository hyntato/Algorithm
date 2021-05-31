import java.util.*;

class Search {
    Map<String, List<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        // 지원자별 가능한 조합의 그룹을 map에 저장
        for(String i: info) {
            String[] split = i.split(" ");
            int score = Integer.parseInt(split[4]);
            makeGroup(split, score, 0, 0, "");
        }
      
        // 그룹에서 점수를 기준으로 오름차순 정렬
        for(List<Integer> list: map.values()) {
            Collections.sort(list);
        }
        
        int[] answer = new int[query.length];
        int idx = 0;
        
        // 쿼리에 해당되는 그룹 찾기, binary search
        for(String q: query) {
            String tmp = q.replaceAll(" and ", "");
            String key = tmp.replace(" " + tmp.split(" ")[1], "");
            int score = Integer.parseInt(tmp.split(" ")[1]);
            
            if(map.containsKey(key))
                answer[idx++] = binarySearch(map.get(key), score);
            else
                answer[idx++] = 0;
        }
        
        return answer;
    }
    
    public void makeGroup(String[] split, int score, int start, int select, String key) {
        if(select == split.length-1) {
            List<Integer> list = map.getOrDefault(key, new ArrayList<Integer>());
            list.add(score);
            map.put(key, list);
            return;
        }
        for(int i=start; i<split.length-1; i++) {
            makeGroup(split, score, i+1, select+1, key+split[i]);
            makeGroup(split, score, i+1, select+1, key+"-");
        }
    }
    
    public int binarySearch(List<Integer> list, int score) {
        int start = 0;
        int end = list.size()-1;
        
        while(start <= end) {
            int mid = (start+end) / 2;
            if(list.get(mid) < score)
                start = mid + 1;
            else
                end = mid - 1;
        }
        
        return list.size() - start;
    }
}
