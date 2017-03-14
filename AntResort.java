import java.util.*;


public class AntResort{
	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		
		int[][] atob = new int[m][2];
		for(int i=0;i<m;i++){
			atob[i][0] = scanner.nextInt();
			atob[i][1] = scanner.nextInt();
		}
		
		Arrays.sort(atob,new Comparator<int[]>(){
			public int compare(int[] r , int [] c){
				return Integer.compare(r[0] ,c[0]);
			}});
		
        int[][] btoa = Arrays.copyOf(atob,m);
		
		Arrays.sort(btoa,new Comparator<int[]>(){
			public int compare(int[] r , int [] c){
				return Integer.compare(r[1] ,c[1]);
			}});
		
		
		
		System.out.println("Did I read it right?");
		System.out.println(m);
		for(int i=0;i<m;i++){
			System.out.println(atob[i][0]+" "+atob[i][1]);
		}
		System.out.println("Did I read it right 2?");
		System.out.println(m);
		for(int i=0;i<m;i++){
			System.out.println(btoa[i][0]+" "+btoa[i][1]);
		}
		
		
		/*
		int resorts = 0;
		for(int i=0;i<m;i++){
			for(int j=0;j<i;j++){
				if(atob[j][0]<atob[i][0] && atob[j][1]>atob[i][1])
					resorts++;
				else if(atob[j][0]>atob[i][0] && atob[j][1]<atob[i][1])
					resorts++;
			}
		}
		*/
		/*
		TreeSet<Integer> tm = new TreeSet<Integer>();
		int resorts = 0;
		for(int i=0;i<m;i++){
			resorts += tm.tailSet(atob[i][1]).size();
			tm.add(atob[i][1]);
			
		}
		*/
		int resorts = 0;
		for(int i=0;i<m;i++){
			if(atob[i][0]<btoa[i][0] && atob[i][1]>btoa[i][1])
				resorts++;
			else if(atob[i][0]>btoa[i][0] && atob[i][1]<btoa[i][1])
				resorts++;
		}
		
		System.out.println(resorts);
	}
}
/*
A very industrious ant, Anty, has been working tirelessly for mapping out the arrangement of clotheslines between the apartment buildings  and . Anty knows that there are  clothlines hanging between  and  as straight lines, each end attached to one apartment. Anty has also observed that two clotheslines intersect if one starts at a lower floor and ends at a higher floor than the other. Formally  and  intersect if  and , or  and .

Anty has thought of a very clever and industrious plan: he wants to open resort hotels at each intersection for his fellow ants. Given the arrangement of clotheslines, find how many hotels Anty can open.

Note: Each pairwise intersection of clotheslines counts as a separate intersection.

Note: Each floor in each apartment can only have one clothesline attached to it.

Input Format

On the first line, integer , the number of clotheslines.

On the next  lines, integers  and , respectively the floors in apartments  and  to which clothesline  is attached. .

Constraints



Output Format

One integer, the total number of intersections of clotheslines.

Sample Input 0

3
2 3
3 1
1 2
Sample Output 0

2
Sample Input 1

4
2 0
3 1
5 10
4 8
Sample Output 1

0
*/