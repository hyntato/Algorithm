import java.util.*;

class Raceway {
    public int solution(int[][] board) {
        int N = board.length;
        int[][] map = new int[N][N];
        for(int[] m: map) {
            Arrays.fill(m, Integer.MAX_VALUE);
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0 , 0 ,-1, 1};
        Queue<Road> q = new LinkedList<Road>();
        
        q.offer(new Road(0, 0, 0, 3));
        q.offer(new Road(0, 0, 0, 1));
        
        while(!q.isEmpty()) {
            Road road = q.poll();
            
            for(int i=0; i<dx.length; i++) {
                int nx = road.getX() + dx[i];
                int ny = road.getY() + dy[i];
                if(0<=nx && nx<N && 0<=ny && ny<N && board[nx][ny]!=1) {
                    int cost = road.getCost() + 100;
                    if(road.getDir() != i)
                        cost += 500;
                    if(cost <= map[nx][ny]) {
                        map[nx][ny] = cost;
                        q.offer(new Road(nx, ny, cost, i));
                    }
                }
            }
        }
        
        return map[N-1][N-1];
    }
}

class Road {
    private int x, y;
    private int cost;
    private int dir;  // 0(up), 1(down), 2(left), 3(right)
    
    public Road(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
    public int getCost() { return this.cost; }
    public int getDir() { return this.dir; }
}
