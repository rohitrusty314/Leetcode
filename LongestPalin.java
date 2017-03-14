import java.util.*;

public class LongestPalin{
	public static void main(String[] args){
		String s = "gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv";
		//String s = "bbbab";
		int q = longestPalindromeSubseq(s);
		System.out.println(q);
	}
	
	public static int longestPalindromeSubseq(String s){
		HashMap<String, Integer> subs = new HashMap<String, Integer>();
		int q = memoSubseq(s,subs);
		return q;
	}
	
	public static int memoSubseq(String s, HashMap<String, Integer> subs){
		int q = 0;
		int i = 0;
		int j = s.length()-1;
		int qij, qi, qj;
		String newSubstr1, newSubstr2, newSubstr3;
		
		
		if(s.length() < 1) return 0;
		if(s.length() == 1) return 1;
		//System.out.println(i+" "+j);
		newSubstr1 = s.substring(i+1,j);
		newSubstr2 = s.substring(i+1);
		newSubstr3 = s.substring(i,j);
		
		
		if(s.charAt(i) == s.charAt(j)){
			if(subs.containsKey(newSubstr1))
				qij = subs.get(newSubstr1);

			else{
				qij = memoSubseq(newSubstr1, subs);
				subs.put(newSubstr1, qij);
			}
			q += 2 + qij;
				
		}
		else{
			if(subs.containsKey(newSubstr2))
				qi = subs.get(newSubstr2);
			else{
				qi = memoSubseq(newSubstr2, subs);
				subs.put(newSubstr2, qi);
			}
			
			if(subs.containsKey(newSubstr3))
				qj = subs.get(newSubstr3);
			else{
				qj = memoSubseq(newSubstr3, subs);
				subs.put(newSubstr3, qj);
			}
			//int qj = longestPalindromeSubseq(s.substring(i,j));
			
			if(qi > qj){
				q += qi;
			}
			else{
				q += qj;
			}
		}
		
		return q;
	}
}

/*
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
*/