class WalkingLength {
    public int solution(String dirs) {
        boolean[][][][] visited = new boolean[11][11][11][11];
        int answer = 0;
        
        int fromX = 5, fromY = 5;
        int toX = 5, toY = 5;
        
        for(char dir: dirs.toCharArray()) {
            fromX = toX;
            fromY = toY;
            if(dir == 'U') {
                toX = fromX;
                toY = fromY-1;
            } else if(dir == 'D') {
                toX = fromX;
                toY = fromY+1;
            } else if(dir == 'R') {
                toX = fromX+1;
                toY = fromY;
            } else if(dir == 'L') {
                toX = fromX-1;
                toY = fromY;
            }
            
            if(toX < 0 || 10 < toX || toY < 0 || 10 < toY) {
                toX = fromX;
                toY = fromY;
                continue;
            }
            
            if(!visited[fromX][fromY][toX][toY]) {
                visited[fromX][fromY][toX][toY] = true;
                visited[toX][toY][fromX][fromY] = true;
                answer++;
            }
        }
        return answer;
    }
}
