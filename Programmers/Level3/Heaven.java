class Heaven {
    private int MOD = 20170805;
   
    public int solution(int m, int n, int[][] cityMap) {
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        
        for(int i=0; i<m; i++) {
            if(cityMap[i][0] == 1) break;
            down[i][0] = 1;
        }
        for(int i=0; i<n; i++) {
            if(cityMap[0][i] == 1) break;
            right[0][i] = 1;
        }
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(cityMap[i][j-1] == 0) {
                    right[i][j] = (right[i][j-1] + down[i][j-1]) % MOD;
                } else if(cityMap[i][j-1] == 1) {
                    right[i][j] = 0;
                } else if(cityMap[i][j-1] == 2) {
                    right[i][j] = right[i][j-1];
                }
                
                if(cityMap[i-1][j] == 0) {
                    down[i][j] = (right[i-1][j] + down[i-1][j]) % MOD;
                } else if(cityMap[i-1][j] == 1) {
                    down[i][j] = 0;
                } else if(cityMap[i-1][j] == 2) {
                    down[i][j] = down[i-1][j];
                }
            }
        }
        return (right[m-1][n-1] + down[m-1][n-1]) % MOD;
    }
}

/*
// 관점 바꾸고 3차원 배열로 구현
class Heaven {
    private int MOD = 20170805;
   
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m+1][n+1][2];  // 0: right, 1: down
        
        dp[1][1][0] = dp[1][1][1] = 1;
        
        for(int i=1; i<=m; i++) {
            for(int j=1; j<=n; j++) {
                if(cityMap[i-1][j-1] == 0) {
                    dp[i][j][0] += (dp[i][j-1][0] + dp[i-1][j][1]) % MOD;  // dp[1][1][0] = 1을 유지하기 위함
                    dp[i][j][1] += (dp[i][j-1][0] + dp[i-1][j][1]) % MOD;
                } else if(cityMap[i-1][j-1] == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                } else {
                    dp[i][j][0] = dp[i][j-1][0];
                    dp[i][j][1] = dp[i-1][j][1];
                }
            }
        }
        return dp[m][n][0];  // dp[m][n][0] == dp[m][n][1] (도착점은 cityMap이 0이기 때문)
    }
}
*/
