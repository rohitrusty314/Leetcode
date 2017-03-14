


public class AddNumbers{
	public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
  
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(8);
		
		n1.next = n2;
		n2.next = null;
		
		ListNode n4 = new ListNode(0);
		/*ListNode n5 = new ListNode(9);
		ListNode n6 = new ListNode(9);
		ListNode n7 = new ListNode(9);
		
		n4.next = n5;
		n5.next = n6;
		//n6.next = null;
		n6.next = n7;
		n7.next = null;*/
		n4.next = null;
		
		ListNode rn = addTwoNumbers(n1,n4);
		
		for(ListNode x=rn;x!=null;x=x.next)
			System.out.print(x.val+" ");
		//System.out.print(x.val);
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
		int carry = 0, dig = 0;
		ListNode l3 = null, currNode = null, x = null, y = null;
		
		for(x=l1,y=l2;x!=null && y!=null;x=x.next,y=y.next){
			dig = carry+x.val+y.val;
			carry = 0;
			
			if(dig>9){
				carry = dig/10;
				dig = dig%10;
			}
			
			ListNode newNode = new ListNode(dig);
			newNode.next = null;
			
			if(l3 == null){
				l3 = newNode;
				currNode = newNode;
			}
			
			else{
				currNode.next = newNode;
				currNode = newNode;
			}
		}
		
		if(x!=null){
			for(ListNode i=x;i!=null;i=i.next){
				dig = carry+i.val;
				carry = 0;
				if(dig>9){
					carry = dig/10;
					dig = dig%10;
				}
				
				ListNode newNode = new ListNode(dig);
			    newNode.next = null;
				
				currNode.next = newNode;
				currNode = newNode;
			}
		}
		
		else if(y!=null){
			for(ListNode i=y;i!=null;i=i.next){
				dig = carry+i.val;
				carry = 0;
				if(dig>9){
					carry = dig/10;
					dig = dig%10;					
				}
				
				ListNode newNode = new ListNode(dig);
			    newNode.next = null;
				
				currNode.next = newNode;
				currNode = newNode;
			}
		}
		
		
		if(carry>0){
			ListNode newNode = new ListNode(carry);
			newNode.next = null;
			currNode.next = newNode;
		}
		
		
		
		return l3;
	}
}

/*
You are given two linked lists representing two non-negative numbers. 
The digits are stored in reverse order and each of their nodes contain a single digit. 
Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/