package imperative;
import java.util.HashSet;
import java.util.Set;

public class PerfectNumber {

	public static class STATE {
		public static String ABUNDANT = "ABUNDANT";
		public static String DEFICIENT = "DEFICIENT";
		public static String PERFECT = "PERFECT";
	}

	public static Set<Integer> divisors(int n){
		
		Set<Integer> divisors = new HashSet<>();
		
		for(int i=1; i<=n; i++) {
			if((n%i)==0) {
				divisors.add(i);
			}
		}
		return divisors;
	}
	
	public static String process(int n) {
		
		int divisors_sum = 0;
		
		for(int i=1; i<n; i++) {
			if((n%i)==0) {
				divisors_sum+=i;
			}
		}
		
		if(divisors_sum<n) {
			return "DEFICIENT";
		}else if(divisors_sum>n) {
			return "ABUNDANT";
		}else {
			return "PERFECT";
		}
		
	}
	
	public static String detect(int n) {
		//System.out.println("Number "+n+" is: "+process(n));
		return process(n);
	}
	
}
