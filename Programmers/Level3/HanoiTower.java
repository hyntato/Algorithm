class HanoiTower {
    private int[][] answer;
    private int count = 0;
    
    public int[][] solution(int n) {
        answer = new int[(int)Math.pow(2, n)-1][2];
        hanoi(n, 1, 2, 3);
        return answer;
    }
    
    public void hanoi(int n, int from, int tmp, int to) {
        if(n == 1) {
            answer[count][0] = from;
            answer[count][1] = to;
            count++;
            return;
        }
        hanoi(n-1, from, to, tmp);
        answer[count][0] = from;
        answer[count][1] = to;
        count++;
        hanoi(n-1, tmp, from, to);
    }
}
