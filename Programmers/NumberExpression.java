class NumberExpression {
    public int solution(int n) {
        int answer = 0;
      
        for(int i=1; i<=n; i++) {
            int start = i;
            int sum = 0;
            while(sum < n) {
                sum += start++;
            }
            if(sum == n) answer++;
        }
      
        return answer;
    }
}
