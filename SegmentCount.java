public class SegmentCount{
	public static void main(String[] args){
		String s = ", , , ,        a, eaefa";
		int count = countSegments(s);
		System.out.println(count);
	}
	
	public static int countSegments(String s){
		if(s.length() == 0)
			return 0;
		
		String[] segments = s.split(" ");
		int count = segments.length;
		int scount = 0;
		for(int i=0;i<count;i++){
			System.out.println(i+": "+segments[i].length());
			if(segments[i].length()>0)
				scount++;
		}
		return scount;
	}
}

/*
Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/