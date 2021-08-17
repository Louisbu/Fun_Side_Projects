package recursionStuff;

public class Recursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (float i = 1; i < 100; i++) {
			System.out.println(factorial(i));
		}
	}

	public static float factorial(float a) {
		if (a == 1) {
			return 1;
		}

		return a * factorial(a - 1);
	}

}
