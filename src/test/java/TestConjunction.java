import examples.while_ut1.ast.*;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;
import sun.awt.SunHints;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Emanuel Chalela on 31/8/2016.
 */
public class TestConjunction {
    @Test
    public void TestConjunctionRandom(){
        TruthValue t1 = new TruthValue(true);
        Assignment bool1 = new Assignment("bool1", t1);
        Assert.assertNotNull(bool1);
        System.out.print("bool1 = " + bool1.expression + "\n");

        TruthValue t2 = new TruthValue(false);
        Assignment bool2 = new Assignment("bool2", t2);
        Assert.assertNotNull(bool2);
        System.out.print("bool2 = " + bool2.expression + "\n");


        Conjunction conj = new Conjunction(bool1.expression,bool2.expression);
        Boolean evaluate = (Boolean) conj.evaluate(new HashMap<String, Object>());
        Assert.assertFalse(evaluate);
    }

    @Test
    public void TestCompareEqual(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = true; b = false; if (!(a && b)) then { c = 1;} else { c = 0; }}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(1.0, evaluate.get("c"));
            Assert.assertNotEquals(0.0, evaluate.get("c"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
