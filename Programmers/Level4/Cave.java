import java.util.*;

class Cave {
    private List<Integer>[] biList;
    private List<Integer>[] uniList;
    private boolean answer = true;

    public boolean solution(int n, int[][] path, int[][] order) {
        biList = new ArrayList[n];
        uniList = new ArrayList[n];
        for(int i=0; i<n; i++) {
            biList[i] = new ArrayList<Integer>();
            uniList[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<path.length; i++) {
            biList[path[i][0]].add(path[i][1]);
            biList[path[i][1]].add(path[i][0]);
        }
        
        // 단방향 그래프 만들기
        boolean[] visited_ = new boolean[n];
        makeUni(0, visited_);
        
        for(int i=0; i<order.length; i++) {
            if(order[i][1] == 0) return false;
            uniList[order[i][1]].add(order[i][0]);
        }
        
        // cycle 탐색
        boolean[] visited = new boolean[n];
        boolean[] finished = new boolean[n];
        for(int i=1; i<n; i++) {
            if(!visited[i]) {
                isCycle(i, visited, finished);
                if(!answer) break;
            }
        }
        
        return answer;
    }
    
    public void makeUni(int start, boolean[] visited) {
        visited[start] = true;
        for(int n: biList[start]) {
            if(!visited[n]) {
                uniList[n].add(start);
                makeUni(n, visited);
            }
        }
    }
    
    public void isCycle(int start, boolean[] visited, boolean[] finished) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{start, uniList[start].size()});
        visited[start] = true;
        
        while(!stack.isEmpty()) {
            int[] after = stack.pop();
            int num = after[0];
            int size = after[1];
            
            if(size > 0) {
                stack.push(new int[]{num, size-1});
                int before = uniList[num].get(size-1);
                
                if(!visited[before]) {
                    stack.push(new int[]{before, uniList[before].size()});
                    visited[before] = true;
                }
                else if(!finished[before]) {
                    answer = false;
                    return;
                }
            }
            else {
                finished[num] = true;
            }
            
        }
        
    }

}
