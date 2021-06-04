class SteppingStone {
    public int solution(int[] stones, int k) {
        int start = 1;
        int end = 200000000;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            if(isCrossable(stones, k, mid))
                start = mid + 1;
            else
                end = mid - 1;
        }
        return start;
    }
    
    public boolean isCrossable(int[] stones, int k, int mid) {
        int cnt = k;
        for(int stone: stones) {
            if(stone <= mid) 
                cnt--;
            else
                cnt = k;
            if(cnt == 0) return false;
        }
        return true;
    }
}
