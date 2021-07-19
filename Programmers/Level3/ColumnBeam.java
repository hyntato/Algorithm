import java.util.*;

class ColumnBeam {
    private boolean[][] co;
    private boolean[][] bo;
    private int n;
    
    public int[][] solution(int n, int[][] build_frame) {
        co = new boolean[n+1][n+1];
        bo = new boolean[n+1][n+1];
        this.n = n;
        int cnt = 0;
        
        for(int[] bf: build_frame) {
            if(bf[2] == 0 && bf[3] == 1 && isAddableCo(bf[0], bf[1])) {  // 기둥 설치 
                cnt++;
                co[bf[0]][bf[1]] = true;
            }
            if(bf[2] == 1 && bf[3] == 1 && isAddableBo(bf[0], bf[1])) {  // 보 설치 
                cnt++;
                bo[bf[0]][bf[1]] = true;
            }
            if(bf[2] == 0 && bf[3] == 0) {  // 기둥 삭제 
                co[bf[0]][bf[1]] = false;
                if(isDeletable(bf[0], bf[1])) {
                    cnt--;
                } else {
                    co[bf[0]][bf[1]] = true;
                }
            }
            if(bf[2] == 1 && bf[3] == 0) {  // 보 삭제 
                bo[bf[0]][bf[1]] = false;
                if(isDeletable(bf[0], bf[1])) {
                    cnt--;
                } else {
                    bo[bf[0]][bf[1]] = true;
                }
            }
        }
        
        int[][] answer = new int[cnt][3];
        int idx = 0;
        
        for(int x=0; x<=n; x++) {
            for(int y=0; y<=n; y++) {
                if(co[x][y]) {
                    answer[idx][0] = x;
                    answer[idx][1] = y;
                    answer[idx][2] = 0;
                    idx++;
                }
                if(bo[x][y]) {
                    answer[idx][0] = x;
                    answer[idx][1] = y;
                    answer[idx][2] = 1;
                    idx++;
                }  
            }
        }
        return answer;
    }
    
    public boolean isAddableCo(int x, int y) {
        if(y == 0 || (0<y && co[x][y-1]) || (0<x && bo[x-1][y]) || bo[x][y]) {
            return true;
        }
        return false;
    }
    public boolean isAddableBo(int x, int y) {
        if((0<y && co[x][y-1]) || (x<n && 0<y && co[x+1][y-1]) || (0<x && x<n && bo[x-1][y] && bo[x+1][y])) {
            return true;
        }
        return false;
    }
    public boolean isDeletable(int x, int y) {
        for(int ny=0; ny<=n; ny++) {
            for(int nx=0; nx<=n; nx++) {
                if((co[nx][ny] && !isAddableCo(nx, ny)) || (bo[nx][ny] && !isAddableBo(nx, ny))) {
                    return false;
                } 
            }
        }
        return true;
    }
}
