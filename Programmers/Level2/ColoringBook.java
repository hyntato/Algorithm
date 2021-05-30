class ColoringBook {
    
    // 상하좌우
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    int m, n;
    int[][] picture;
    boolean[][] visited;
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        this.m = m;
        this.n = n;
        this.picture = picture;
        this.visited = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    numberOfArea++;
                    int size = dfs(i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int dfs(int x, int y) {
        int size = 1;
        visited[x][y] = true;
        
        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(0<=nx && nx<m && 0<=ny && ny<n) {
                if(!visited[nx][ny] && picture[nx][ny] == picture[x][y]) {
                    size += dfs(nx, ny);
                }
            }
        }
        
        return size;
    }
}
