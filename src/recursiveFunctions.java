
public class recursiveFunctions {
	public static void main(String[] args) {
		System.out.println(printInBinary(countWays(25)));
	}
	public static String printInBinary(int N) {
		if (N < 0) {
			return "-" + printInBinary(-N);
		} else if (N < 2) {
			return "" + N;
		} else {
			return printInBinary(N / 2) + (N % 2);		
		}
	}
	
	public static int countWays(int numStairs) {
		if (numStairs < 4) {
			return numStairs;
		} else {
			return countWays(numStairs - 1) + countWays(numStairs - 2);
		}
	}
}
