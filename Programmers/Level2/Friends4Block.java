import java.util.*;

class Friends4Block {
    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                blocks[i][j] = board[i].charAt(j);
            }
        }
        
        boolean isRemoved = true;
        
        while(isRemoved) {
            isRemoved = false;
            boolean[][] remove = new boolean[m][n];
            for(boolean[] r: remove) {
                Arrays.fill(r, false);
            }
            
            // 2*2 블록 검사
            for(int i=0; i<m-1; i++) {
                for(int j=0; j<n-1; j++) {
                    char curr = blocks[i][j];
                    if(curr!='0' && curr==blocks[i][j+1] && curr==blocks[i+1][j] && curr==blocks[i+1][j+1]) {
                        isRemoved = true;
                        remove[i][j] = true;
                        remove[i][j+1] = true;
                        remove[i+1][j] = true;
                        remove[i+1][j+1] = true;
                    }
                }
            }
            
            // 한줄씩 떨어뜨리기
            for(int i=0; i<m; i++) {
                for(int j=0; j<n; j++) {
                    if(remove[i][j]) {
                        for(int k=i; k>0; k--) {
                            blocks[k][j] = blocks[k-1][j];
                        }
                        blocks[0][j] = '0';
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(blocks[i][j] == '0') answer++;
            }
        }
        return answer;
    }
}
