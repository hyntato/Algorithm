class Rectangle {
    public long solution(int w, int h) {
        int gcd = gcd(Math.max(w, h), Math.min(w, h));
        int remove = w + h - gcd;
        return w*(long)h - remove;
    }
    
    public int gcd(int a, int b) {
        while(b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
