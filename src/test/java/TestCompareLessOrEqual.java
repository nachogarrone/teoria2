import examples.while_ut1.ast.*;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Emanuel Chalela on 31/8/2016.
 */
public class TestCompareLessOrEqual {
    @Test
    public void TestCompareLessOrEqualRandom(){
        Random rand = new Random();
        Assignment num1 = new Assignment("num1", Numeral.generate(rand, 0, 99));
        Assert.assertNotNull(num1);
        System.out.print("num1 = " + num1.expression + "\n");

        Assignment num2 = new Assignment("num2", Numeral.generate(rand, 100, 199));
        Assert.assertNotNull(num2);
        System.out.print("num2 = " + num2.expression + "\n");
        CompareLessOrEqual compareLessOrEq = new CompareLessOrEqual(num1.expression,num2.expression);
        Boolean evaluate = (Boolean) compareLessOrEq.evaluate(new HashMap<String, Object>());
        Assert.assertTrue(evaluate);
    }

    @Test
    public void TestCompareLessOrEqual(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 3; b = 4; if (a <= b) then { c = 1;} else { c = 0; }}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(1.0, evaluate.get("c"));
            Assert.assertNotEquals(0.0, evaluate.get("c"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
