
import java.util.*;

public class hypothesisTesting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> data = new ArrayList<>();
		double sum = 0.0;
		double mean = 0.0;
		double var = 0.0;
		double sd = 0.0;

		for (int i = 0; i < 10; i++) {
			data.add(sc.nextDouble());
			sc.next();
		}

		for (int j = 0; j < data.size(); j++) {
			sum += data.get(j);

		}

		mean = sum / data.size();

		for (int k = 0; k < data.size(); k++) {
			var += Math.pow(data.get(k) - mean, 2) / (data.size() - 1);
		}
		sd = Math.sqrt(var);

		System.out.println(mean + " " + sd);

	}

}
