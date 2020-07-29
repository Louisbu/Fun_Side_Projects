//import javax.swing.*;
import java.util.*;

public class Interface {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        ArrayList<Integer> grades = new ArrayList<Integer>();
        for (int i = 0; i < total; i++) {
        	grades.add(sc.nextInt());
        	
        }
        //System.out.println(grades);
        int Ds = Collections.frequency(grades, 2);
        int Cs = Collections.frequency(grades, 3);
        int Bs = Collections.frequency(grades, 4);
        int As = Collections.frequency(grades, 5);
        
        System.out.println(Ds +" " + Cs + " "+ Bs + " " + As);
    }
}