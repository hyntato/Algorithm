// 모든 경우의 수에서 조건을 만족하는 경우만 채택

class GroupPicture {
    private char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[] visited = new boolean[friends.length];
    private String[] data;
    private int count = 0;
        
    public int solution(int n, String[] data) {
        this.data = data;
        permutation(friends.length, "");
        return count;
    }
    
    public void permutation(int r, String str) {
        if(r == 0) {
            if(isPossible(str)) count++;
            return;
        }
        for(int i=0; i<friends.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                permutation(r-1, str+friends[i]);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPossible(String str) {
        for(String d: data) {
            int f1 = str.indexOf(d.charAt(0));
            int f2 = str.indexOf(d.charAt(2));
            int diff = d.charAt(4) - '0' + 1;
            char op = d.charAt(3);
            
            if(op == '=' && Math.abs(f1 - f2) != diff)
                return false;
            else if(op == '<' && Math.abs(f1 - f2) >= diff)
                return false;
            else if(op == '>' && Math.abs(f1 - f2) <= diff)
                return false;
        }
        return true;
    }
}
