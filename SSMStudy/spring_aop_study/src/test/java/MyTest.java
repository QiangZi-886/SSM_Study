import com.yang.proxy.CalculatorProxy;
import com.yang.service.Calculator;
import com.yang.service.MyCalculator;
import org.junit.Test;

public class MyTest {

    @Test
    public void test01(){
//        MyCalculator myCalculator = new MyCalculator();
//        System.out.println(myCalculator.add(1, 2));
        Calculator calculator = CalculatorProxy.getCalculator(new MyCalculator());
        calculator.add(1,1);
        calculator.sub(1,1);
        calculator.mul(1,1);
        calculator.div(1,1);
    }
}
