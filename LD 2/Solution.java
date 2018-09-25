package pack;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


public class Solution {
	
	static int max_number;
	static int[] pow_value_array;
	static int input_X;
	static int input_N;
	static List<Integer> sum_variants = new ArrayList<Integer>();//array that will hold
																 //all possible variations 
																 //of sums
	
	static int init_powerSum(int X, int N) {
		if (N == 0) 
	        return 1; 
		
		input_X = X;
		input_N = N;
		max_number = (int)Math.floor(Math.pow(X, 1.0/N)); //getting root of specific power
														  // which will be max_number
		
		pow_value_array = new int[max_number]; //array which will hold values that
											   //were raised to a specific power
		powerSum(max_number,N); //raising values in power
		combination_generation(pow_value_array.length-1); //generating all possible 
														  //variations of sums
		
		//System.out.println("Max_number(array size): "+max_number);
		//printArray();
		return get_solution_count();
	}

	static void combination_generation(int array_index) {
			int size = sum_variants.size(); //saving size value to avoid 
											//ConcurrentModificationException
			int variant;
			
			if(!sum_variants.isEmpty()) {
				for(int j=0;j<size;j++) {
					
					variant = sum_variants.get(j)+pow_value_array[array_index];
					sum_variants.add(variant);
				}
			}
			variant = pow_value_array[array_index];
			sum_variants.add(variant);				
		
			if(array_index==0)
				return;
			
			combination_generation(array_index-1);
	}
	
	static int get_solution_count() {
		
		Predicate<Integer> predicate = l-> l==input_X;
		
		return (int)sum_variants.parallelStream()
								.filter(predicate)
								.count();
	}
	
	
	static void powerSum(int current_X, int N) {
		if(current_X > 0) {
			int current_number = (int)Math.floor(Math.pow(current_X, N));	
			pow_value_array[max_number-current_X] = current_number;
			powerSum(current_X-1,N);
		}
	}
	
	public static void main(String[] args) 
	{ 
	    int x = 600, n = 2; 
	    
	   try {
	    System.out.println(init_powerSum(x, n)); 
	   }
	   
	   catch(OutOfMemoryError e) {
		   System.out.println(e); 
	   }
	}
	
	/*
	static void printArray() {
		System.out.print("Array of powered values: ");
		for(int i=0;i<max_number;i++) {
			System.out.print(pow_value_array[i]+" ");
		}
		System.out.println();
	}
	*/
}


