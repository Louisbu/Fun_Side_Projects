import java.util.*;
import java.lang.Math;
import java.io.*;

public class CountingNumbers {

	public static void main(String[] args) throws IOException {
		// Scanner sc = new Scanner(System.in);

		File f = new File("/Users/louisbu/Documents/GitHub/PythonSideProjects/factorial.txt");
		FileWriter w = new FileWriter("/Users/louisbu/Documents/GitHub/PythonSideProjects/frequencies.txt");
		// FileWriter x = new
		// FileWriter("/Users/louisbu/Documents/GitHub/PythonSideProjects/differences.txt");
		Scanner sc = new Scanner(f);

		String input = "0";

		while (!input.equals("-1")) {
			input = sc.nextLine();
			if (input.equals("-1")) {
				break;
			}
			System.out.println(input);

			input = sc.nextLine();
			int[] temp = getFrequency(input);
			double[] temp1 = statistics(temp);

			for (int i = 0; i < temp.length; i++) {
				w.write(temp[i] + "\t");
			}
			w.write("\n");
			
			for (int i = 0; i < temp1.length; i++) {
				w.write(temp1[i] + "\t");
			}
			w.write("\n");
		}

	}

	public static double[] statistics(int[] arr) {
		double[] data = new double[arr.length + 1];
		double sum = 0;
		// sets the first entry of the array as the number of 0's in the result
		data[0] = arr[0];
		// calculate sum
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
		}
		double ave = sum / (arr.length - 1);
		data[1] = ave;

		for (int i = 2; i < arr.length; i++) {
			data[i] = arr[i-1] - ave;
		}
		return data;
	}

	public static int findMin(int[] arr) {
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}

	public static int[] getDifference(int[] frequency) {
		int[] difference = new int[frequency.length];
		int min = findMin(frequency);

		System.out.println(min);

		for (int i = 1; i < frequency.length; i++) {
			difference[i] = frequency[i] - min;
		}

		return difference;
	}

	public static int[] getFrequency(String input) {
		int[] arr = new int[input.length()];

		for (int i = 0; i < input.length(); i++) {
			arr[i] = Integer.parseInt((Character.toString(input.charAt(i))));
		}

		int[] freq = new int[10];

		for (int i = 0; i < arr.length; i++) {

			switch (arr[i]) {
			case 0:
				freq[0]++;
				break;
			case 1:
				freq[1]++;
				break;
			case 2:
				freq[2]++;
				break;
			case 3:
				freq[3]++;
				break;
			case 4:
				freq[4]++;
				break;
			case 5:
				freq[5]++;
				break;
			case 6:
				freq[6]++;
				break;
			case 7:
				freq[7]++;
				break;
			case 8:
				freq[8]++;
				break;
			case 9:
				freq[9]++;
				break;
			}
		}

		return freq;
	}

}
