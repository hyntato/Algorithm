class Nlcm {
    public int solution(int[] arr) {
        int lcm = arr[0];
        for (int i=1; i<arr.length; i++) {
            int a = Math.max(lcm, arr[i]);
            int b = Math.min(lcm, arr[i]);
            lcm = lcm*arr[i] / gcd(a, b);
        }
        return lcm;
    }
    
    // 최대공약수 - 유클리드 호제법
    public int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}
