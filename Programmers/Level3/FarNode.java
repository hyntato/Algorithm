import java.util.*;

class FarNode {
    public int solution(int n, int[][] edge) {
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=1; i<list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
        
        for(int[] e: edge) {
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }
        
        int[] dist = new int[n+1];
        int max = bfs(list, dist, 1);
        
        int answer = 0;
        for(int i=2; i<dist.length; i++) {
            if(max == dist[i]) answer++;
        }        
        return answer;
    }
    
    public int bfs(List<Integer>[] list, int[] dist, int start) {
        int max = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 1;
        
        while(!q.isEmpty()) {
            int from = q.poll();
            
            for(int to: list[from]) {
                if(dist[to] == 0) {
                    dist[to] = dist[from] + 1;
                    max = dist[to];
                    q.offer(to);
                }
            }
        }
        return max;
    }
}
