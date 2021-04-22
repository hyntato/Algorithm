class Snail {
    public int[] solution(int n) {
        int[][] snail = new int[n][n];
        int x = -1;
        int y = 0;
        int num = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=i; j<n; j++) {
                switch (i % 3) {
                case 0:
                    snail[++x][y] = ++num;
                    break;
                case 1:
                    snail[x][++y] = ++num;
                    break;
                case 2:
                    snail[--x][--y] = ++num;
                    break;
                
                }
            }
        }
        
        int idx = 0;
        int[] answer = new int[num];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer[idx++] = snail[i][j];
            }
        }
        return answer;
    }
}
