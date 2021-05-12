class NextNumber {
    public int solution(int n) {
        int cnt = makeBinary(n);
        while(true) {
            if(cnt == makeBinary(++n)) break;
        }
        return n;
    }
    
    public int makeBinary(int n) {
        int cnt = 0;
        while(n > 0) {
            if(n%2 == 1) cnt++;
            n /= 2;
        }
        return cnt;
    }
}
