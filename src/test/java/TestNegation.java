import examples.while_ut1.ast.*;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Emanuel Chalela on 31/8/2016.
 */
public class TestNegation {
    @Test
    public void TestNegationRandom(){
        TruthValue t1 = new TruthValue(true);
        Assignment bool1 = new Assignment("bool1", t1);
        Assert.assertNotNull(bool1);
        System.out.print("bool1 = " + bool1.expression + "\n");

        TruthValue t2 = new TruthValue(false);
        Assignment bool2 = new Assignment("bool2", t2);
        Assert.assertNotNull(bool2);
        System.out.print("bool2 = " + bool2.expression + "\n");

        Negation neg1 = new Negation(bool1.expression); // false
        Assert.assertNotNull(neg1);

        Negation neg2 = new Negation(bool2.expression); // true
        Assert.assertNotNull(neg2);


        Boolean evaluate1 = (Boolean) neg1.evaluate(new HashMap<String, Object>());
        Assert.assertFalse(evaluate1);

        Boolean evaluate2 = (Boolean) neg2.evaluate(new HashMap<String, Object>());
        Assert.assertTrue(evaluate2);
    }

    @Test
    public void TestNegation(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = false; b = !a;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(true, evaluate.get("b"));
            Assert.assertNotEquals(false, evaluate.get("b"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
