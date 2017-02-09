import java.util.ArrayList;

/**
 * Created by youli on 2017/2/7.
 */
public class CalculationImpl implements Calculation {
    public ArrayList<Integer> cube(int number) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < number; i++) {
            a.add(i);
        }
        System.out.println("finished");
        return a;
    }
}
