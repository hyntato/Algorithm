import java.util.*;

class CandidateKey {
    public int solution(String[][] relation) {
        int answer = 0;
        int N = relation[0].length;
        List<List<String>> cList = new ArrayList<>();
        
        for(int i=0; i<N; i++) {
            List<String> list = new ArrayList<>();
            boolean[] visited = new boolean[N];
            combination(N, i+1, 0, visited, "", list);
            cList.add(list);
        }
    
        for(int i=0; i<N; i++) {
            List<String> list = cList.get(i);
            for(int j=0; j<list.size(); j++) {
                if(isCandidateKey(list.get(j), relation)) {
                    answer++;
                    removeKey(cList, i+1, list.get(j));
                }
            }
        }
        return answer;
    }
    
    public void combination(int n, int r, int start, boolean[] visited, String key, List<String> list) {
        if(r == 0) {
            list.add(key);
            return;
        }
        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(n, r-1, i+1, visited, key+i, list);
                visited[i] = false;
            }
        }
    }
    
    public boolean isCandidateKey(String key, String[][] relation) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<relation.length; i++) {
            String tmp = "";
            for(int j=0; j<relation[0].length; j++) {
                if(key.contains(j+"")) tmp += relation[i][j];
            }
            if(list.contains(tmp))
                return false;
            else
                list.add(tmp);
        }
        return true;
    }
    
    public void removeKey(List<List<String>> cList, int start, String key) {
        for(int i=start; i<cList.size(); i++) {
            List<String> list = cList.get(i);
            Iterator iter = list.iterator();
            while(iter.hasNext()) {
                String str = (String)iter.next();
                if(str.length() - str.replaceAll("[" + key + "]", "").length() == key.length())
                    iter.remove();
            }
        }
    }
}
