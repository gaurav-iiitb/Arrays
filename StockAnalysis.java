import java.util.*;
class StockAnalysis {
	public static void main(String args[]) {
		
		Scanner scan = new Scanner(System.in);
		int l = scan.nextInt();
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(3);
		A.add(8);
		A.add(11);
		A.add(9);
		A.add(6);
		A.add(4);
		A.add(2);
		A.add(1);

		ArrayList<Integer> B = new ArrayList<Integer>();
		B.add(1);
		B.add(2);
		B.add(3);
		B.add(4);

		//System.out.println("Max Profix given minimum "+ l +" days: " + minimumLDays(A,l));
	
		//System.out.println("Max Profit given exactly "+ l +" days: " + exactlyLDays(A,l));

		System.out.println("Max Profit given maximum "+ l +" days: " + maximumLDays(A,l));
	}

	//The person is allowed to sell his stocks only after minimum of l days
	public static int minimumLDays(ArrayList<Integer> A, int l){
		
		int min = A.get(0);
		int profit = A.get(l)-A.get(0);
		int max = A.get(l)-A.get(0);
		
		for(int j=l; j<A.size(); j++) {
			
			profit = A.get(j)-min;
			if(profit > max)
				max = profit;
			if(A.get(j-l)<min)
				min = A.get(j-l);

		}

		return max;
	}

	//The person has to sell it exactly after l days
	public static int exactlyLDays(ArrayList<Integer> A, int l) {
		
		int min = A.get(0);
		int profit = A.get(l)-A.get(0);
		int max = A.get(l)-A.get(0);

		for(int j=l; j<A.size(); j++){
			
			profit = A.get(j)-min;
			if(profit>max)
				max = profit;
			
			min = A.get(j-l+1);
		}
		return max;
	}

	//The person has to sell it in maximum l days
	public static int maximumLDays(ArrayList<Integer> A, int l) {
	
		
		//Creating Queue of numbers
		ArrayList<Integer> queue = new ArrayList<Integer>();
		int tail = 0;
		int head;
		queue.add(0);

		int min = A.get(0);
		int max = A.get(0);
		int temp;
		for(int i=1; i<A.size(); i++) {

			temp = A.get(i) - min;
			if(temp>max)
				max = temp;

			head = i;
			if(i-l < 0) {

				if(A.get(i)<min)
					min = A.get(i);
				queue.add(i);	
			} else {
				tail++;
				queue.add(i);
				temp = head-1;
				while(temp>=tail){
					if(A.get(temp)>A.get(head)){
						min = A.get(head);
						temp--;
					}
					else {
						min = A.get(temp);
						temp--;
					}
				}
			}

		}

				
		return max;
	}
}
