import examples.while_ut1.ast.*;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestMultiplication {
    @Test
    public void testMultRandom() {
        Random rand = new Random();
        Assignment mult1 = new Assignment("mult1", Numeral.generate(rand, 0, 100));
        Assignment mult2 = new Assignment("mult2", Numeral.generate(rand, 0, 100));
        Assert.assertNotNull(mult1);
        Assert.assertNotNull(mult2);
        Multiplication multiplication = new Multiplication(mult1.expression, mult2.expression);
        Assert.assertNotNull(multiplication);
        Double result = (Double) multiplication.evaluate(new HashMap<String, Object>());
        Double s1 = ((Numeral) mult1.expression).getNumber();
        Double s2 = ((Numeral) mult2.expression).getNumber();
        Assert.assertTrue((s1 * s2) == result);
        System.out.print(s1 + " * " + s2 + " = " + result);
    }

    @Test
    public void testMultParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 7 * 9;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(63.0, evaluate.get("a"));
            Assert.assertNotEquals(64.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
