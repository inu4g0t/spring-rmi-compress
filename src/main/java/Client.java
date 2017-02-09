/**
 * Created by youli on 2017/2/7.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args)  {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-beans.xml");
        Calculation calculation = (Calculation)context.getBean("calculationBean");
        System.out.println(calculation.cube(100000).size());
    }
}