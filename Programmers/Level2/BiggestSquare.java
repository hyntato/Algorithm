class BiggestSquare {
    public int solution(int [][]board) {
        if (board.length < 2 || board[0].length < 2) return 1;
        
        int max = 0;
        for(int i=1; i<board.length; i++) {
            for(int j=1; j<board[0].length; j++) {
              
                if(board[i][j] != 0) {
                    int min = Math.min(board[i][j-1], Math.min(board[i-1][j-1], board[i-1][j]));
                    board[i][j] = min+1;
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        return max*max;
    }
}
