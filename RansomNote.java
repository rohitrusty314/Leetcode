import java.util.TreeMap;

public class RansomNote{
	public static void main(String[] main){
		String ransomNote = "aa";
		String magazine = "aab";
		boolean can = canConstruct(ransomNote, magazine);
		System.out.println(can);
	}
	
	public static boolean canConstruct(String ransomNote,String magazine){
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		int value;
		char key;
		for(int i=0;i<magazine.length();i++){
			key = magazine.charAt(i);
			if(map.containsKey(key)){
				value = map.get(key);
				map.remove(key);
				map.put(key,value+1);
			}
			else
				map.put(key,1);
		}
		
		char curr;
		for(int i=0;i<ransomNote.length();i++){
			curr = ransomNote.charAt(i);
			if(!map.containsKey(curr))
				return false;
			else if(map.get(curr) == 0)
				return false;
			else{
				value = map.get(curr);
				map.remove(curr);
				map.put(curr,value-1);
			}
		}
		return true;
	}
}


/*
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/