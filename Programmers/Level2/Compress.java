class Compress {
    private int[][] arr;
    private int[] answer;
    
    public int[] solution(int[][] arr) {
        this.arr = arr;
        this.answer = new int[2];
        compress(0, 0, arr.length);
        return answer;
    }
    
    public void compress(int x, int y, int n) {
        if(n == 1) {
            answer[arr[x][y]]++;
            return;
        }
        
        if(isAllSame(x, y, n)) {
            compress(x, y, 1);
        }
        else {
            compress(x, y, n/2);
            compress(x+n/2, y, n/2);
            compress(x, y+n/2, n/2);
            compress(x+n/2, y+n/2, n/2);
        }
    }
    
    public boolean isAllSame(int x, int y, int n) {
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if(arr[i][j] != arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}
