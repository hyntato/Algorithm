import java.util.*;

class Point {
    private int x, y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() { return this.x; }
    public int getY() { return this.y; }
}

class ShortestDistance {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        // 상하좌우
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        Queue<Point> q = new LinkedList<Point>();
        boolean[][] visited = new boolean[n][m];
        
        q.offer(new Point(0, 0));
        visited[0][0] = true;
        
        while(!q.isEmpty()) {
            Point p = q.poll();
            
            for(int i=0; i<dx.length; i++) {
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];
                
                if(0<=nx && nx<n && 0<=ny && ny<m) {
                    if(!visited[nx][ny] && maps[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        maps[nx][ny] = maps[p.getX()][p.getY()] + 1;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        if(visited[n-1][m-1])
            return maps[n-1][m-1];
        else
            return -1;
    }
}
