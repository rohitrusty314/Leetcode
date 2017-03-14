public class StockEx{
	public static void main(String[] args){
		StockEx se = new StockEx();
		
		int[] prices = {};
		int profit = se.maxProfit(prices);
		System.out.println(profit);
	}
	
	public int maxProfit(int[] prices){
		if(prices.length==0)
			return 0;
		int profit = 0;
		int cp = prices[0];
		//int sp = prices[0];
		int day_bought = 0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]<cp){
				//System.out.println(prices[i]);
				//System.out.println("bought on day "+i);
				cp = prices[i];
				day_bought = i;
			}
			
			if(prices[i]>cp && i>day_bought){
				//System.out.println("Sold on day "+i+" at "+prices[i]);
				if((prices[i] - cp) > profit){
					profit = prices[i] - cp;
					//System.out.println("Sold on day "+i+" at "+prices[i]+" with profit "+profit);
				}
			}
		}
		
		return profit;
	}
}

/*
121. Best Time to Buy and Sell Stock

Say you have an array for which the ith element is the price of a given 
stock on day i.

If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm 
to find the maximum profit.

Example 1:
Input: [7, 1, 5, 3, 6, 4]
Output: 5

max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be 
larger than buying price)

Example 2:
Input: [7, 6, 4, 3, 1]
Output: 0

In this case, no transaction is done, i.e. max profit = 0.
*/