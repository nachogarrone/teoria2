import examples.while_ut1.ast.Subtraction;
import examples.while_ut1.ast.Assignment;
import examples.while_ut1.ast.Numeral;
import examples.while_ut1.parser.Parser;
import org.junit.Test;
import java.util.HashMap;
import org.junit.Assert;
import java.util.Random;


public class TestSubstraction{
    @Test
    public void testSub() {
        Numeral num1 = new Numeral(3.0);
        Assignment numm1 = new Assignment("num1",num1);
        Assert.assertNotNull(num1);
        Assert.assertEquals(3.0,num1);
        Numeral num2 = new Numeral(2.0);
        Assert.assertNotNull(num2);
        Assert.assertEquals(2.0,num2);
        Assignment numm2 = new Assignment("num2", num2);
        Subtraction sub = new Subtraction(numm1.expression,numm2.expression);
        Assert.assertNotNull(sub);
        Assert.assertEquals(sub,1.0);
    }
}
