class Network {
    private boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, computers);
                answer++;
            }
        }
        return answer;
    }
    
    public void dfs(int start, int[][] computers) {
        visited[start] = true;
        for(int i=0; i<computers.length; i++) {
            if(!visited[i] && computers[start][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
