public class NumberToWord{
	public static String[] tens = {
		"",
		"ten",
		"twenty",
		"thirty",
		"forty",
		"fifty",
		"sixty",
		"seventy",
		"eighty",
		"ninety"
	};
	
	public static String[] num = {
		"",
		"one",
		"two",
		"three",
		"four",
		"five",
		"six",
		"seven",
		"eight",
		"nine",
		"ten",
		"eleven",
		"twelve",
		"thirteen",
		"fourteen",
		"fifteen",
		"sixteen",
		"seventeen",
		"eighteen",
		"nineteen"
	};
	
	public static void main(String[] args){
		int number = 99000;
		System.out.println(number);
		NumberToWord nw = new NumberToWord();
		String word = nw.toWord(number);
		
		System.out.println(word);
	}
	
	public String toWord(int number){
		int place = 0, rem;
		String word = "";
		while(number > 0){
			
			if(number < 20 && place%3 == 0){
				//System.out.println(place);
				word = wordForNumber(number,place) +" "+ word;
				number = number/20;
			}
					
			else{
				rem = number%10;
				word = wordForNumber(rem,place) +" "+ word;
				number = number/10;
			}
			
			//System.out.println(word);
			
			place++;
		}
		
		return word;
	}
	
	public String wordForNumber(int digit,int place){
		String word = "";
		//System.out.println(digit);
		switch(place){
			case 0: word = num[digit];
					break;
			case 1: word = tens[digit];
					break;
			case 2: if(digit>0) 
						word = num[digit] +" "+ "hundred";
					break;
			case 3: word = num[digit] + " " + "thousand";
					break;
			case 4: word = tens[digit];
					break;
					
		}
		
		return word;
	}
}