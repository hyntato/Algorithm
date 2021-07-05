import java.util.*;

class MakeZero {
    private long answer = 0;
    private long[] arr;
    private boolean[] visited;
    private List<Integer>[] list;
    
    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        arr = new long[n];
        visited = new boolean[n];
        list = new ArrayList[n];
        int sum = 0;
        
        for(int i=0; i<list.length; i++) {
            list[i] = new ArrayList<Integer>();
            arr[i] = a[i];
            sum += a[i];
        }
        
        if(sum != 0) {
            return -1;
        }
        
        for(int[] edge: edges) {
            list[edge[0]].add(edge[1]);
            list[edge[1]].add(edge[0]);
        }
        
        dfs(0);
        return answer;
    }
    
    public long dfs(int curr) {
        visited[curr] = true;
        
        for(int i=0; i<list[curr].size(); i++) {
            int next = list[curr].get(i);
            if(!visited[next]) {
                arr[curr] += dfs(next);
            }
        }
        answer += Math.abs(arr[curr]);
        
        return arr[curr];
    }
}
