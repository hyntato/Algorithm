class TravelRoute {
    private String answer = null;
    private String[][] tickets;
    private boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", 0);
        
        return answer.split(" ");
    }
    
    public void dfs(String start, String path, int count) {
        if(count == tickets.length) {
            if(answer == null)
                answer = path;
            else if(answer.compareTo(path) > 0)
                answer = path;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], path+" "+tickets[i][1], count+1);
                visited[i] = false;
            }
        }
    }
}
