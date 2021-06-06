class Stations {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int reach = w*2 + 1;
        
        int start = 1;
        int end = n;
        
        for(int i=0; i<stations.length; i++) {
            end = stations[i] - w - 1;
            if(start <= end) {
                int q = (end-start+1) / reach;
                int r = (end-start+1) % reach;
                if(r == 0)
                    answer += q;
                else
                    answer += q + 1;
            }
            start = stations[i] + w + 1;
        }
        
        if(start <= n) {
            end = n;
            int q = (end-start+1) / reach;
            int r = (end-start+1) % reach;
            if(r == 0)
                answer += q;
            else
                answer += q + 1;
        }
        
        return answer;
    }
}
