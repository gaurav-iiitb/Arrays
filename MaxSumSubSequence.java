import java.util.*;

class MaxSumSubSequence {
	public static void main(String args[]) {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(-2);
		A.add(1);
		A.add(-3);
		A.add(4);
		A.add(-1);
		A.add(2);
		A.add(1);
		A.add(-5);

		//Testing purpose
		ArrayList<Integer> B = new ArrayList<Integer>();
                B.add(1);
                B.add(2);
                B.add(3);
                B.add(4);

		Scanner scan = new Scanner(System.in);
		int l = scan.nextInt();
		//System.out.println("Max Subsequence of any length: " + subSequenceMaxSum(A));
		//System.out.println("Max SubSequence of length exactly " + l + ": " + exactlyL(B,l));
		//System.out.println("Max SubSequence of length atleast "+ l +": "+atleastL(B,l));
		System.out.println("Max SubSequence of length atmost "+ l +" :"+atmostL(B,l));

}

	//Returns max sum of SubSequence of any length
	public static int subSequenceMaxSum(ArrayList<Integer> A){
		
		//Creating an array of prefixes
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		int sum=0, min, c=A.get(0);
		for(int i=1; i<A.size(); i++){
		
			prefix.add(c);
			c += A.get(i);
		}
		prefix.add(c);


		//Get the max value and then assign it to max variable
		int temp, max=prefix.get(0);
		for(int i=0; i<prefix.size(); i++){
			if(prefix.get(i)>=max)
				max = prefix.get(i);
		}

		//Finding the max difference between max and min
		min =  prefix.get(0);
		for(int i=1; i<prefix.size(); i++){
		
			temp = prefix.get(i)-min;
			if(temp > max){
				max = temp;
			}
			if(prefix.get(i)<min){
				min = prefix.get(i);
			}

		}
		return max;

	}

	//Max SubSequence of length exactly L
	public static int exactlyL(ArrayList<Integer> A, int l) {
		
		//Initial value of max
		int max=0, sum=0, temp;
		for(int i=0; i<l; i++){
			sum += A.get(i);
		}
		max=sum;
		for(int i=1; i<A.size()-1; i++) {
			temp = sum - A.get(i-1) + A.get(i+1);
			if(temp>max)
				max = temp;
			sum = temp;
		}
		return max;
	}

	//Max SubSequence of length atleast L
	public static int atleastL(ArrayList<Integer> A, int l) {
		
		//Creating a prefix arraylist of all numbers
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		int sum = 0, temp;
		for(int j=0; j<A.size(); j++) {
			
			sum += A.get(j);			
			prefix.add(sum);
		}

		//Initializing the value of max 
		//Consider case [1,2,3,4] you'll get a better idea
		int max = prefix.get(l-1);
		for(int i=l-1; i<prefix.size(); i++) {
			if(prefix.get(i)>max)
				max = prefix.get(i);
		}

		
		int min = prefix.get(0);
		for(int j=l; j<prefix.size(); j++){
			
			if(prefix.get(j-l)<min)
                        	min = prefix.get(j-l);
			
			temp = prefix.get(j)-min;
			if(temp>max){
				max = temp;
			}	
		}

		return max;
	}

	//Max SubSequence of length atmost L
        public static int atmostL(ArrayList<Integer> A, int l) {
                
		//Calculating the array of prefixes
		ArrayList<Integer> prefix = new ArrayList<Integer>();
		int sum=0, temp;
		for(int i=0; i<A.size(); i++){
			sum += A.get(i);
			prefix.add(sum);
		}

		ArrayList<Integer> queue = new ArrayList<Integer>();
		int min = prefix.get(0);
                int max = prefix.get(0);
		int tail = 0;
		int head;
		queue.add(tail);
                for(int i=1; i<prefix.size(); i++) {

                        temp = prefix.get(i) - min;
                        if(temp>max)
                                max = temp;

                        head = i;
                        if(i-l < 0) {

                                if(prefix.get(i)<min)
                                        min = prefix.get(i);
                                queue.add(i);
                        } else {
                                tail++;
                                queue.add(i);
                                temp = head-1;
                                while(temp>=tail){
                                        if(prefix.get(temp)>prefix.get(head)){
                                                min = prefix.get(head);
                                                temp--;
                                        }
                                        else {
                                                min = prefix.get(temp);
                                                temp--;
                                        }
                                }
                        }

                }

		return max;
        }

}
