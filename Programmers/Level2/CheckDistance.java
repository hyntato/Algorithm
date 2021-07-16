class CheckDistance {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int[] answer = new int[5];
    private boolean[][] visited = new boolean[5][5];
    
    public int[] solution(String[][] places) {
        for(int i=0; i<5; i++) {
            answer[i] = 1;
        }
        
        for(int i=0; i<5; i++) {
            visited = new boolean[5][5];
            for(int j=0; j<5; j++) {
                for(int k=0; k<5; k++) {
                    if(places[i][j].charAt(k) == 'P') {
                        visited[j][k] = true;
                        dfs(places[i], i, j, k, 0);
                        visited[j][k] = false;
                    }   
                }
            }
        }
        return answer;
    }
    
    public void dfs(String[] place, int num, int x, int y, int dist) {
        if(dist > 2) {
            return;
        }
        if(0 < dist && dist <= 2 && place[x].charAt(y) == 'P') {
            answer[num] = 0;
            return;
        }
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0<=nx && nx<5 && 0<=ny && ny<5) {
                if(!visited[nx][ny] && place[nx].charAt(ny) != 'X') {
                    visited[nx][ny] = true;
                    dfs(place, num, nx, ny, dist+1);
                    visited[nx][ny] = false;
                }
            }
        }
        visited[x][y] = false;
    }
}

/*
class CheckDistance {
    private int N = 5;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = check(places[i]);
        }
        return answer;
    }
    
    public int check(String[] place) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(i<N-1 && j<N-1) {
                    if(place[i].charAt(j)=='P' && place[i].charAt(j+1)=='P') {
                        return 0;
                    }
                    if(place[i].charAt(j)=='P' && place[i+1].charAt(j)=='P') {
                        return 0;
                    }
                    
                    if(place[i].charAt(j)=='P' && place[i+1].charAt(j+1)=='P') {
                        if(place[i].charAt(j+1)=='X' && place[i+1].charAt(j)=='X') 
                            continue;
                        else 
                            return 0;
                    }
                    if(place[i].charAt(j+1)=='P' && place[i+1].charAt(j)=='P') {
                        if(place[i].charAt(j)=='X' && place[i+1].charAt(j+1)=='X') 
                            continue;
                        else 
                            return 0;
                    }
                    
                    if(place[i].charAt(j+1)=='P' && place[i+1].charAt(j+1)=='P') {
                        return 0;
                    }
                    if(place[i+1].charAt(j)=='P' && place[i+1].charAt(j+1)=='P') {
                        return 0;
                    }
                }
                if(j<N-2) {
                    if(place[i].charAt(j)=='P' && place[i].charAt(j+2)=='P') {
                        if(place[i].charAt(j+1)=='X') 
                            continue;
                        else 
                            return 0;
                    }
                }
                if(i<N-2) {
                    if(place[i].charAt(j)=='P' && place[i+2].charAt(j)=='P') {
                        if(place[i+1].charAt(j)=='X') 
                            continue;
                        else 
                            return 0;
                    }
                }
            }
        }
        return 1;
    }
}
*/
