class School {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n+1][m+1];
        
        map[1][1] = 1;
        for(int[] puddle: puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(map[i][j] == -1)
                    continue;
                if(map[i-1][j] != -1)
                    map[i][j] = (map[i][j] + map[i-1][j]) % 1000000007;
                if(map[i][j-1] != -1)
                    map[i][j] = (map[i][j] + map[i][j-1]) % 1000000007;
            }
        }
        
        return map[n][m];
    }
}

/*
14, 16라인: 0행, 0열은 0이니까 더해줘도 상관없음!

if(1 < i && map[i-1][j] != -1)
if(1 < j && map[i][j-1] != -1) 로 해도됨
*/
