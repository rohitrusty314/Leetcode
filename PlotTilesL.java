public class PlotTilesL{
	public static void main(String[] args){
		int r = 1, c = 1;
		int[][] b = new int[8][8];
		
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				if(i==r && j==c) b[i][j] = 0;
				else b[i][j] = -1;
			}
		}
		
		placeTile(b,0,7,0,7);
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				System.out.print(b[i][j]+"\t");
			}
			System.out.print("\n");
		}
	}
	
	public static void placeTile(int[][] b, int pi, int ri, int pj, int rj){
		if((ri-pi) > 2 && (rj-pj) > 2){
			int qi = (int)Math.floor((pi + ri) / 2);
			int qj = (int)Math.floor((pj + rj) / 2);
			
			
			placeTile(b,pi,qi,pj,qj);
			placeTile(b,pi,qi,qj+1,rj);
			placeTile(b,qi+1,ri,pj,qj);
			placeTile(b,qi+1,ri,qj+1,rj);
			System.out.println("i "+pi+" to "+qi+" and j "+pj+" to "+qj);
			System.out.println("i "+pi+" to "+qi+" and j "+(qj+1)+" to "+rj);
			System.out.println("i "+(qi+1)+" to "+ri+" and j "+pj+" to "+qj);
			System.out.println("i "+(qi+1)+" to "+ri+" and j "+(qj+1)+" to "+rj);
		}
	}
	
	public static int corner_quadrant(int pi,int qi,int ri,int pj,int qj,int rj,int ci,int cj){
		if((ci>=pi && ci<=qi) && (cj>=pj && cj<=qj)) return 1;
		else if((ci>=pi && ci<=qi) && (cj>=qj+1 && cj<=rj)) return 2;
		else if((ci>=qi+1 && ci<=ri) && (cj>=pj && cj<=qj)) return 3;
		else return 4;
	}
}