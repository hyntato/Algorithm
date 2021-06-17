class MaxCounters {
    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int max = 0;
        int maxCounter = 0;

        for(int x: A) {
            if(x <= N) {
                if(counter[x-1] < maxCounter)
                    counter[x-1] = maxCounter+1;
                else
                    counter[x-1]++;
                if(max < counter[x-1]) max = counter[x-1];
            }
            else {
                maxCounter = max;
            }
        }

        for(int i=0; i<counter.length; i++) {
            if(counter[i] < maxCounter) {
                counter[i] = maxCounter;
            }
        }
        return counter;
    }
}
