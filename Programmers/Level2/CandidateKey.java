import java.util.*;

class CandidateKey {
    private List<String> cases = new ArrayList<>();
    private List<String> candidates = new ArrayList<>();
    
    public int solution(String[][] relation) {
        int n = relation[0].length;
        // 모든 컬럼 조합 구하기
        for(int i=0; i<n; i++) {
            combination(n, i+1, 0, new boolean[n], "");
        }
        
        // case에 따라 데이터 조합 -> 중복, 최소 체크
        for(String currCase: cases) {
            if(isUnique(currCase, relation) && isMinimal(currCase)) {
                candidates.add(currCase);
            }
        }
        return candidates.size();
    }
    
    public void combination(int n, int r, int start, boolean[] visited, String acc) {
        if(r == 0) {
            cases.add(acc);
            return;
        }
        for(int i=start; i<n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combination(n, r-1, i+1, visited, acc+i);
                visited[i] = false;
            }
        }
    }
    
    public boolean isUnique(String currCase, String[][] relation) {
        Set<String> set = new HashSet<>();
        for(String[] row: relation) {
            String result = "";
            for(char idx: currCase.toCharArray()) {
                result += row[Integer.parseInt(idx+"")];
            }
            if(!set.add(result)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isMinimal(String currCase) {
        for(String candidate: candidates) {
            // 02, 012 주의 -> contains로 비교하면 안됨
            String regExp = "[" + candidate + "]";
            if(currCase.length() - currCase.replaceAll(regExp, "").length() == candidate.length()) {
                return false;
            }
        }
        return true;
    }
}

