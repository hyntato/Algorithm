class WallCheck {
    private int[][] weaks;
    private int[] dists;
    private boolean isAnswer;
    
    public int solution(int n, int[] weak, int[] dist) {
        weaks = remakeWeak(n, weak);
        dists = dist;
        isAnswer = false;
        
        int answer = -1;
        int len = dist.length;
        
        for(int i=1; i<=len; i++) {
            boolean[] visited = new boolean[len];
            int[] result = new int[i];
            permutation(0, visited, result);
            if(isAnswer) {
                answer = i;
                break;
            }
        }
        return answer;
    }
    
    public int[][] remakeWeak(int n, int[] weak) {
        int len = weak.length;
        int[][] weaks = new int[len][len+1];
        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                weaks[i][j] = weak[(j+i)%len];
                if(j+i >= len) {
                    weaks[i][j] += n;
                }
            }
            weaks[i][len] = 2*n;
        }
        return weaks;
    }
    
    public void permutation(int cnt, boolean[] visited, int[] result) {
        if(cnt == result.length) {
            if(isAllChecked(result)) {
                isAnswer = true;
            }
            return;
        }
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[cnt] = dists[i];
                permutation(cnt+1, visited, result);
                visited[i] = false;
            }
        }
    }
    public boolean isAllChecked(int[] result) {
        for(int[] weak: weaks) {
            int idx = 0;
            for(int res: result) {
                for(int i=idx; i<weak.length-1; i++) {
                    if(weak[idx] + res < weak[i+1]) {
                        idx = i+1;
                        break;
                    }
                }
                if(idx == weak.length-1) return true;
            }
        }
        return false;
    }
}
