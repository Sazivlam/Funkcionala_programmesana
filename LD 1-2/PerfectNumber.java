package functional;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {

	public enum STATE {
		DEFICIENT, PERFECT, ABUNDANT;
	}

	public static Set<Integer> divisors(int n){
		
		return IntStream
				.rangeClosed(1, n/2)
				.filter((i) -> n % i == 0)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new));
	}
	
	public static STATE process(int n) {
		
		
		Integer divisors_sum =
				IntStream
				.rangeClosed(1, n/2)
				.filter((i) -> n % i == 0)
				.boxed()
				.collect(Collectors.toCollection(HashSet::new))
				.parallelStream()
				.reduce(0, Integer::sum);
		
		Predicate<Integer> Deficient = integer -> integer < n;
		Predicate<Integer> Abundant = integer -> integer > n;
		
		if(Deficient.test(divisors_sum)) {
			return STATE.DEFICIENT;
		}else if(Abundant.test(divisors_sum)) {
			return STATE.ABUNDANT;
		}else {
			return STATE.PERFECT;
		}
		
	}
	
	public static STATE detect(int n) {
		//System.out.println("Number "+n+" is: "+process(n));
		return process(n);
	}
	
}