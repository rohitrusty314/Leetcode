import java.util.TreeMap;

public class MakesSum{
	public static void main(String[] args){
		int sum = 45;
		int[] a = {1,3,44,5,6,9};
		find(a,sum);
	}
	
	public static void find(int[] a, int sum){
		TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
		
		int makesSum = 0;
		for(int i=0;i<a.length;i++){
			map.put(i,a[i]);
			System.out.println("key "+i+" has value "+map.get(i));
		}
		
		for(int i=0;i<a.length;i++){
			makesSum = sum - a[i];
			System.out.println(a[i]);
			System.out.println(map.containsValue(makesSum));
			if(map.containsValue(makesSum)){
				System.out.println(a[i]+" + "+makesSum+" = "+sum);
				break;
			}
				
		}
	}
	
	
}