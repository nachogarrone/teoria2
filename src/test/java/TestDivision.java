import examples.while_ut1.ast.*;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestDivision {
    @Test
    public void testDivRandom() {
        Random rand = new Random();
        Assignment div1 = new Assignment("div1", Numeral.generate(rand, 0, 100));
        Assignment div2 = new Assignment("div2", Numeral.generate(rand, 0, 100));
        Assert.assertNotNull(div1);
        Assert.assertNotNull(div2);
        Division division = new Division(div1.expression, div2.expression);
        Assert.assertNotNull(division);
        Double result = (Double) division.evaluate(new HashMap<String, Object>());
        Double s1 = ((Numeral) div1.expression).getNumber();
        Double s2 = ((Numeral) div2.expression).getNumber();
        Assert.assertTrue((s1 / s2) == result);
        System.out.print(s1 + " / " + s2 + " = " + result);
    }

    @Test
    public void testDivParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 10 / 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(5.0, evaluate.get("a"));
            Assert.assertNotEquals(3.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
