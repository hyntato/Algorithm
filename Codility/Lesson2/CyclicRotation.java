class CyclicRotation {
    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++)  {
            result[(i+K)%A.length] = A[i];
        }
        return result;
    }
}
