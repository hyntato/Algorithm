class Ranking {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n+1][n+1];
        for(int[] result: results) {
            graph[result[0]][result[1]] = true;
        }
        
        // 플로이드 와샬
        for(int k=1; k<=n; k++) {
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if(graph[i][k] && graph[k][j]) {
                        graph[i][j] = true;
                    }
                }
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            int count = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j] || graph[j][i]) count++;  // 이김 또는 짐
            }
            if(count == n-1) answer++;
        }
        return answer;
    }
}

/*
import java.util.*;

class Ranking {
    public int solution(int n, int[][] results) {
        List<Integer>[] winList = new ArrayList[n+1];
        List<Integer>[] loseList = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++) {
            winList[i] = new ArrayList<Integer>();
            loseList[i] = new ArrayList<Integer>();
        }
        for(int[] result: results) {
            winList[result[0]].add(result[1]);
            loseList[result[1]].add(result[0]);
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            boolean[] visited = new boolean[n+1];
            int sum = dfs(i, winList, visited);
            
            visited = new boolean[n+1];
            sum += dfs(i, loseList, visited);
            
            if(sum == n-1) answer++;
        }
        return answer;
    }
    
    public int dfs(int start, List<Integer>[] list, boolean[] visited) {
        int count = 0;
        for(int to: list[start]) {
            if(!visited[to]) {
                visited[to] = true;
                count += dfs(to, list, visited) + 1;
            }
        }
        return count;
    }
}
*/
