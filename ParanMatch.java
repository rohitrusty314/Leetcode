import java.util.Stack;

public class ParanMatch{
	public static void main(String[] args){
		String s = "[]";
		boolean valid = isValid(s);
		System.out.println(valid);
	}
	
	public static boolean isValid(String s){
		Stack<Character> paranStack = new Stack<Character>();
		char[] cArray = s.toCharArray();
		char p;
		
		for(int i=0;i<cArray.length;i++){
			if(cArray[i]=='[' || cArray[i] == '{' || cArray[i] == '('){
				paranStack.push(cArray[i]);
			}
			
			if(cArray[i]==']' || cArray[i] == '}' || cArray[i] == ')'){
				
				if(paranStack.isEmpty()) return false;
				else if(paranStack.peek() != compliment(cArray[i])) return false;
				else p = paranStack.pop();
			}
		}
		
		if(paranStack.isEmpty()) return true;
		else return false;
	}
	
	public static char compliment(char c){
		if(c == ')')
			return '(';
		else if(c == '}')
			return '{';
		else
			return '[';
	}
}

/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

Subscribe to see which companies asked this question
*/