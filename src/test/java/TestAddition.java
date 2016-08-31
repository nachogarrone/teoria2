import examples.while_ut1.ast.Addition;
import examples.while_ut1.ast.Assignment;
import examples.while_ut1.ast.Numeral;
import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by nachogarrone on 29/8/16.
 */
public class TestAddition {

    @Test
    public void testAddRandom() {
        Random rand = new Random();
        Assignment sum1 = new Assignment("sum1", Numeral.generate(rand, 0, 100));
        Assignment sum2 = new Assignment("sum2", Numeral.generate(rand, 0, 100));
        Assert.assertNotNull(sum1);
        Assert.assertNotNull(sum2);
        Addition addition = new Addition(sum1.expression, sum2.expression);
        Assert.assertNotNull(addition);
        Double result = (Double) addition.evaluate(new HashMap<String, Object>());
        Double s1 = ((Numeral) sum1.expression).getNumber();
        Double s2 = ((Numeral) sum2.expression).getNumber();
        Assert.assertTrue((s1 + s2) == result);
        System.out.print(s1 + " + " + s2 + " = " + result);
    }

    @Test
    public void testAddParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 1 + 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(3.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
