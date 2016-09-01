import examples.while_ut1.ast.Subtraction;
import examples.while_ut1.ast.Assignment;
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
public class TestSubstraction {
    @Test
    public void testSubRandom() {
        Random rand = new Random();
        Assignment num1 = new Assignment("num1", Numeral.generate(rand, 0, 100));
        Assignment num2 = new Assignment("num2", Numeral.generate(rand, 0, 100));
        Assert.assertNotNull(num1);
        Assert.assertNotNull(num2);
        Subtraction subtraction = new Subtraction(num1.expression, num2.expression);

        Assert.assertNotNull(subtraction);
        Double result = (Double) subtraction.evaluate(new HashMap<String, Object>());
        Double n1 = ((Numeral) num1.expression).getNumber();
        Double n2 = ((Numeral) num2.expression).getNumber();
        Assert.assertTrue((n1 - n2) == result);
        System.out.print(n1 + " - " + n2 + " = " + result);
    }

    @Test
    public void testSubParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 2 - 1;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(1.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
