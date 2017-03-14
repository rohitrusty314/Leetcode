public class DateSort{
	public static void main(String[] args){
		int[][] date = new int[args.length][3];
		int i,j,k,l;
		for(i=0;i<args.length;i++){
			//System.out.println(args[i]);
			String[] temp = args[i].split("/");
			//System.out.println(temp[0]+temp[1]+temp[2]);
			date[i][0] = Integer.parseInt(temp[0]);
			date[i][1] = Integer.parseInt(temp[1]);
			date[i][2] = Integer.parseInt(temp[2]);
			//System.out.println(date[i][0]+":"+date[i][1]+":"+date[i][2]);
 		}
		
		sortDate(date,0,date.length,2);
		//sort each year entry month wise
		for(i=0;i<date.length-1;){
			for(j=i+1;j<date.length;j++){
				if(date[i][2]!=date[j][2]){
					break;
				}
			}
			sortDate(date,i,j,0);
			
			for(k=i;k<j-1;){
				for(l=k+1;k<j;l++){
					if(date[k][0]!=date[l][0]){
						break;
					}
				}
				
				//System.out.println("kl "+k+" "+l);
				sortDate(date,k,l,1);
				k = l;
			}
			
			i = j;
			
		}
		/*
		//sort each year, and month entry date wise
		for(i=0;i<date.length-1;){
			for(j=i+1;j<date.length;j++){
				if(date[i][2]!=date[j][2]){
					break;
				}
			}
			//System.out.println(i+" "+j);
			
			for(k=i;k<j-1;){
				for(l=k+1;k<j;l++){
					if(date[k][0]!=date[l][0]){
						break;
					}
				}
				
				//System.out.println("kl "+k+" "+l);
				sortDate(date,k,l,1);
				k = l;
			}
			i = j;
			
		}*/
		
		
		for(i=0;i<date.length;i++){
			System.out.println(date[i][0]+"/"+date[i][1]+"/"+date[i][2]);
		}
	}
	
	public static void sortDate(int[][] date,int i, int j,int p){
		int[] temp = new int[3];
		
		for(int k=i;k<j-1;k++){
			for(int l=k+1;l<j;l++){
				if(date[k][p]>date[l][p]){
					temp[0] = date[k][0];
					temp[1] = date[k][1];
					temp[2] = date[k][2];
					
					date[k][0] = date[l][0];
					date[k][1] = date[l][1];
					date[k][2] = date[l][2];
					
					date[l][0] = temp[0];
					date[l][1] = temp[1];
					date[l][2] = temp[2];
					
				}
			}
		}
	}
}