public class CutRodToMinimizeCost {


    public int cutRodToMinimizeCost(int [] markings, int total) {
        int T[][] = new int[total+1][total+1];
        for(int i = 0 ; i < T.length; i++) {
            for(int j=0; j < T[i].length ; j++) {
                T[i][j] = -1;
            }
        }
        return cutRodToMinimizeCost(markings, 0, total, T);
    }

    private int cutRodToMinimizeCost(int[] markings, int start, int end, int T[][]){

        if(T[start][end] != -1) {
            return T[start][end];
        }

        int i;
        for(i=0; i < markings.length; i++){
            if(start < markings[i]) {
                break;
            }
        }
        if(i == markings.length) {
            T[start][end] = 0;
            return 0;
        }
        
        int j;
        for(j=markings.length -1; j >= 0; j--){
            if(end > markings[j]) {
                break;
            }
        }
        if(j == -1) {
            T[start][end] = 0;
            return 0;
        }
        if(i == j){
            T[start][end] = end - start;
            return end - start;
        }
        int cost = end - start;
        int minCost = Integer.MAX_VALUE;
        for(int k=i; k <= j; k++) {
            int c1 = cutRodToMinimizeCost(markings, start, markings[k], T);
            int c2 = cutRodToMinimizeCost(markings, markings[k], end, T);
            if(c1 == Integer.MAX_VALUE || c2 == Integer.MAX_VALUE) {
                continue;
            }
            if(minCost > c1 + c2){
                minCost = c1 + c2;
            }
        }
        if(minCost == Integer.MAX_VALUE) {
            T[start][end] = Integer.MAX_VALUE;
            return Integer.MAX_VALUE;
        }
        T[start][end] = cost + minCost;
        return cost + minCost;
    }
    
    public static void main(String args[]) {
        int markings[] = {2,8,10};
        CutRodToMinimizeCost cr = new CutRodToMinimizeCost();
        int cost = cr.cutRodToMinimizeCost(markings, 20);
        System.out.println(cost);       
    }
}