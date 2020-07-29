import java.util.Scanner;

public class GameMain {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int min = -50;
	int max = 50;
	int range = max - min + 1;
	System.out.println(range);
	sc.close();
    }

}
