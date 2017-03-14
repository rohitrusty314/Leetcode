public class MergeSortJava{
	public static void main(String[] args){
		int[] a = {5,2,4,7,1,3,2,6};
		//int[] a = {1,2,3,4,5,6,7,8};
		//int[] a = {3,7,2,1,6,8,5,4};
		//int[] a = {4,3,2,1};
		//int[] a = {8,7,6,5,4,3,2,1};
		
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		System.out.print("\n");
		int va = 0;
		MergeSortJava ms = new MergeSortJava();
		va = ms.mergeSort(a,0,a.length-1,va);
		
		System.out.println("va "+va);
		
		for(int i=0;i<a.length;i++){
			System.out.print(a[i]+" ");
		}
		
	}
	
	public int mergeSort(int[] a,int p,int r, int va){
		if(p<r){
			int q = (int)Math.floor((p+r)/2);
			
			va = mergeSort(a,p,q,va);
			va = mergeSort(a,q+1,r,va);
			//System.out.print("l "+p+"-"+q+"\n");
			//System.out.print("r "+q+"-"+r+"\n");
			va = merge(a,p,q,r,va);
		}
		
		return va;
		
	}
	
	public int merge(int[] a, int p,int q,int r,int va){
		
		int n1 = q-p+1;
		int n2 = r-q;
		//System.out.println("n1: "+n1);
		//System.out.println("n2: "+n2);
		
		int i,j;
		int[] left = new int[n1];
		int[] right = new int[n2];
		
		for(i=0;i<n1;i++){
			left[i] = a[p+i];
			//System.out.print(left[i]+" ");
		}
		//System.out.print("\n");
		
		for(j=0;j<n2;j++){
			right[j] = a[q+j+1];
			//System.out.print(right[j]+" ");
		}
		//System.out.print("\n");
		
		i = j = 0;
		
		//int va = 0;
		for(int k=p;k<r+1;k++){
			//System.out.println("here");
			if(i==n1){
				a[k] = right[j];
				j++;
			}
			else if(j==n2){
				a[k] = left[i];
				i++;
			}
			else if(left[i]<=right[j]){
				a[k] = left[i];
				i++;
			}
			else{
				va += n1-i;
				//System.out.println(n1-i);
				a[k] = right[j];
				j++;
			}
		}
		
		return va;
	}
	
	
}