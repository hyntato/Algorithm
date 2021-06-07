class NQueen {
    private int n;
    private int count;
    private int[] rows;
    
    public int solution(int n) {
        this.n = n;
        this.count = 0;
        this.rows = new int[n];
        
        backTracking(0);
        return count;
    }
    
    public void backTracking(int colIdx) {
        if(colIdx == n) {
            count++;
            return;
        }
        for(int i=0; i<n; i++) {
            rows[colIdx] = i;            // colIdx열, i행에 퀸 배치
            if(isPossible(colIdx)) {
                backTracking(colIdx+1);
            }
        }
    }
    
    public boolean isPossible(int colIdx) {
        for(int i=0; i<colIdx; i++) {
            if(rows[i] == rows[colIdx])  // 가로 체크
                return false;
            if(Math.abs(i-colIdx) == Math.abs(rows[i]-rows[colIdx]))  // 대각선 체크
                return false;
        }
        return true;
    }
}
