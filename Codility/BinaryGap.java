class BinaryGap {
    public int solution(int N) {
        String binary = makeBinary(N);
        int max = 0;
        int idx = 0;
        int count = 0;

        while(idx < binary.length()) {
        	if(binary.charAt(idx) == '1') {
                if(max < count) max = count;
    			count = 0;
        	}
        	else {
                count++;
            }
        	idx++;
        }
        return max;
    }

    public static String makeBinary(int N) {
        String binary = "";
        while(N >0) {
            if(N%2 == 0) {
                binary = "0" + binary;
            } 
            else {
                binary = "1" + binary;
            }
            N /= 2;
        }
        return binary;
    }
}
