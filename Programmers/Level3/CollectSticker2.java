class CollectSticker2 {
    public int solution(int[] sticker) {
        int N = sticker.length;
        if(N == 1) return sticker[0];
        
        int[] dp = new int[N];
        int[] dp2 = new int[N];
        
        // 1. 첫 번째 스티커를 뜯은 경우
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i=2; i<N-1; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        // 2. 첫 번째 스티커를 뜯지 않은 경우
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2; i<N; i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }
        
        return Math.max(dp[N-2], dp2[N-1]);
    }
}
