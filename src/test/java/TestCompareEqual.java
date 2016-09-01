import examples.while_ut1.ast.Assignment;
import examples.while_ut1.ast.CompareEqual;
import examples.while_ut1.ast.Numeral;
import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Emanuel Chalela on 31/8/2016.
 */
public class TestCompareEqual {

    @Test
    public void TestCompareEqualRandom(){
        Random rand = new Random();
        Assignment num1 = new Assignment("num1", Numeral.generate(rand, 0, 99));
        Assert.assertNotNull(num1);
        System.out.print("num1 = " + num1.expression + "\n");

        Assignment num2 = new Assignment("num2", Numeral.generate(rand, 100, 199));
        Assert.assertNotNull(num2);
        System.out.print("num2 = " + num2.expression + "\n");
        CompareEqual compareEq = new CompareEqual(num1.expression,num2.expression);
        Boolean evaluate = (Boolean) compareEq.evaluate(new HashMap<String, Object>());
        Assert.assertFalse(evaluate);
    }

    @Test
    public void TestCompareEqual(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 3; b = 3; if (a == b) then { c = 1;} else { c = 0; }}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(1.0, evaluate.get("c"));
            Assert.assertNotEquals(0.0, evaluate.get("c"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
