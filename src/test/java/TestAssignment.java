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
public class TestAssignment {
    @Test
    public void testAssignmentRandom() {
        Random rand = new Random();
        Double r = rand.nextDouble();
        Assignment num1 = new Assignment("num1", new Numeral(r));
        Assert.assertNotNull(num1);
        System.out.print(num1.expression + " = " + r);
    }

    @Test
    public void testAssignmentParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(2.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
