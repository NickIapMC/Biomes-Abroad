package znick_.biomesabroad.util.helper;

public class MathHelper {

	public static double map(double n, double lower, double higher, double newLower, double newHigher) {
		if (n >= lower && n <= higher) {
			double relativeN = n - lower;
			double interval = higher - lower;
			double percent = relativeN/interval;
			double newInterval = newHigher - newLower;
			double relativeNew = newInterval * percent;
			double newN = relativeNew + lower;
			
			return newN;
			
		} else throw new ArithmeticException("Number to map must be within the interval!");
	}
	
}
