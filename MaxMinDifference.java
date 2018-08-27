//Since we are using static data members, the memory space provided is common
//Thus when you use Collections.sort(A), it actually sorts the array among all functions
import java.util.*;
class MaxMinDifference {

	public static void main(String args[]){
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		ArrayList<Integer> B = new ArrayList<Integer>();
		A.add(4);
		A.add(2);
		A.add(-3);
		A.add(1);
		B = A;
		System.out.println("Max Difference: " + maxdifference(A));
		System.out.println("Max Difference given j>i: " + conditionalmax(B));
		System.out.println("Min Difference: " + mindifference(A));

	}

	//Finding the max difference between any two elements of the list
	public static int maxdifference(ArrayList<Integer> A){
		
		int max = A.get(0);
		int min = A.get(0);
		for(int i=0; i<A.size(); i++){
		
		
			if(A.get(i)>max)
				max = A.get(i);
			if(A.get(i)<min)
				min = A.get(i);
		}

		return max-min;
	}

	//Finding the minimum difference between any two elements of the list
	//Only possible way is to sort the arraylist cause min difference might not be between minimum numbers
	public static int mindifference(ArrayList<Integer> A) {
		
		int min = A.get(0)-A.get(1), temp;
		ArrayList<Integer> B = new ArrayList<Integer>();
		Collections.sort(A);
	
		//Now since the array is sorted finding the minimum consecutive difference
		for(int i=1; i<A.size()-1; i++){
	
			temp = A.get(i)-A.get(i+1);		
			if(temp<min)
				min = temp;
		}
		return min;
	}

	//Finding the max difference between elements of the array given j>i
	public static int conditionalmax(ArrayList<Integer> B){

		//Can't sort since the order is important
		int min = B.get(0);
		int max = B.get(1)-B.get(0);
		int temp;
		for(int i=1; i<B.size(); i++) {
			
			temp = B.get(i)-min;
			if(temp>max)
				max = temp;
			if(B.get(i)<min)
				min = B.get(i);
		} 
		return max;
	}
}
