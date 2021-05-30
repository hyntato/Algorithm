class Rule124 {
    
    public String solution(int n) {
        String[] nums = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
            answer = nums[n % 3] + answer;
            n = (n-1) / 3;
        }
        
        return answer;
    }
}
/*
1 = 0...1   > 1
2 = 0...2   > 2
3 = 1...0   > 4

4 = 1...1   > 11
5 = 1...2   > 12
6 = 2...0   > 14

7 = 2...1   > 21
8 = 2...2   > 22
9 = 3...0   > 24

10 = 3...1  > 41
11 = 3...2  > 42
12 = 4...0  > 44

13 = 4...1  > 111
*/
