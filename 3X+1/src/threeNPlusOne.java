import java.util.*;
import java.io.*;

public class threeNPlusOne {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();

		bigLoop(init);
	}

	public static int calculateThreeNPlusOne(int a) {

		if (a % 2 == 0) {
			a = a / 2;
		} else {
			a = 3 * a + 1;
		}
		return a;
	}

	public static ArrayList<Integer> calculateLoop(int a) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(a);
		while (a != 1) {
			a = calculateThreeNPlusOne(a);
			arr.add(a);
		}

		return arr;
	}

	public static void bigLoop(int loopNum) throws IOException {
		FileWriter f = new FileWriter("ThreeNPlusOne.txt");
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i <= loopNum; i++) {

			arr = calculateLoop(i);

			for (int j = 0; j < arr.size(); j++) {
				if (j == 0) {
					f.write(arr.get(j) + "\t");
				} else if (j == arr.size() - 1) {
					f.write(arr.get(j) + "\n");
				} else if (j % 30 == 0) {
					f.write(arr.get(j) + "\n\t");
				} else {
					f.write(arr.get(j) + "\t");
				}
			}

			f.flush();
			arr.clear();
		}

		f.close();
	}

	public static int[] differences(int a) {
		int[] temp = new int[a];

		return temp;
	}
}
