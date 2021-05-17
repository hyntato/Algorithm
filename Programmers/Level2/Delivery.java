import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] adj = new int[N+1][N+1];
        for(int[] a: adj) {
            Arrays.fill(a, N*10000);
        }
        for(int[] r: road) {
            adj[r[0]][r[1]] = adj[r[1]][r[0]] = Math.min(adj[r[0]][r[1]], r[2]);
        }
        
        int[] distance = new int[N+1];
        Arrays.fill(distance, N*10000);
        distance[1] = 0;
        
        boolean[] visited = new boolean[N+1];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        
        pq.offer(new int[]{1, 0});  // to, distance(누적 경로)
        
        while(!pq.isEmpty()) {
            int[] to = pq.poll();
            
            if(visited[to[0]]) continue;
            visited[to[0]] = true;
            
            for(int i=1; i<=N; i++) {
                if(!visited[i] && distance[i] > adj[to[0]][i] + distance[to[0]]) {
                    distance[i] = adj[to[0]][i] + distance[to[0]];
                    pq.offer(new int[]{i, distance[i]});
                }
            }
        }
      
        int answer = 0;
        for(int i=1; i<=N; i++) {
            if(distance[i] <= K) answer++;
        }
        return answer;
    }
}
