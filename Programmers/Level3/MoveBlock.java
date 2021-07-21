import java.util.*;

class MoveBlock {
    private int N;
    private int[][] map;
    // 상하좌우
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    // 회전-가로
    private int[] hx = {0, -1, -1, 0};
    private int[] hy = {0, 0, 1, 1};
    
    private int[] c_hx = {1, -1, -1, 1};  // 충돌 검사
    private int[] c_hy = {0, 0, 0, 0};
    // 회전-세로
    private int[] vx = {0, 0, 1, 1};
    private int[] vy = {-1, 0, 0, -1};
    
    private int[] c_vx = {0, 0, 0, 0};    // 충돌 검사 
    private int[] c_vy = {-1, 1, 1, -1};
    // 가로세로
    private int[][] dir = {{0, 1}, {1, 0}};
    
    private Queue<Robot> q = new LinkedList<>();
    private boolean[][] visit_h;
    private boolean[][] visit_v;
    
    public int solution(int[][] board) {
        N = board.length;
        map = new int[N+2][N+2];
        // 패딩 넣기
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map.length; j++) {
                if(i==0 || j==0 || i==map.length-1 || j==map.length-1) {
                    map[i][j] = 1;
                } else {
                    map[i][j] = board[i-1][j-1];
                }
            }
        }
        
        // bfs
        int answer = 0;
        visit_h = new boolean[N+2][N+2];
        visit_v = new boolean[N+2][N+2];
        
        q.offer(new Robot(1, 1, 0, 0));
        visit_h[1][1] = true;
        
        while(!q.isEmpty()) {
            Robot rb = q.poll();
            if(isFinished(rb, N, N)) {
                answer = rb.t;
                break;
            }
            moveRobot(rb, dx, dy, dx, dy, false);
            if(rb.d == 0) {
                moveRobot(rb, hx, hy, c_hx, c_hy, true);
            } else {
                moveRobot(rb, vx, vy, c_vx, c_vy, true);
            }
        }
        return answer;
    }
    
    public boolean isFinished(Robot rb, int ex, int ey) {
        return ((rb.x==ex && rb.y==ey) || (rb.x+dir[rb.d][0]==ex && rb.y+dir[rb.d][1]==ey));
    }
    
    public void moveRobot(Robot rb, int[] mx, int[] my, int[] cx, int[] cy, boolean rotate) {
        for(int i=0; i<mx.length; i++) {
            int nx = rb.x + mx[i];
            int ny = rb.y + my[i];
            
            int nd = rb.d;
            if(rotate) nd = 1-rb.d;
            
            boolean[][] visit = visit_h;
            if(nd == 1) visit = visit_v;
            
            if(visit[nx][ny]) {
                continue;
            }
            if(map[rb.x+cx[i]][rb.y+cy[i]]==0 && map[rb.x+cx[i]+dir[rb.d][0]][rb.y+cy[i]+dir[rb.d][1]]==0) {
                q.offer(new Robot(nx, ny, nd, rb.t+1));
                visit[nx][ny] = true;
            }
        }
    }
    
    class Robot {
        int x, y;
        int d;  // 0: 가로, 1: 세로
        int t;
        public Robot(int x, int y, int d, int t) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.t = t;
        }
        public Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
