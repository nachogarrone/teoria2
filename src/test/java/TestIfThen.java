import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestIfThen {
    @Test
    public void testIfThenTrue(){
        try {
            Stmt statementFalse = (Stmt) (Parser.parse("{if(true) then{a = 100;} else{b = 50;}}").value);
            HashMap<String, Object> evaluateFalse = statementFalse.evaluate(new HashMap<String, Object>());

            Assert.assertNotNull(evaluateFalse.get("a"));
            Assert.assertNull(evaluateFalse.get("b"));
            Assert.assertEquals(100.0, evaluateFalse.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void testIfThenFalse(){
        try {
            Stmt statementFalse = (Stmt) (Parser.parse("{if(false) then{a = 100;} else{b = 50;}}").value);
            HashMap<String, Object> evaluateFalse = statementFalse.evaluate(new HashMap<String, Object>());

            Assert.assertNotNull(evaluateFalse.get("b"));
            Assert.assertNull(evaluateFalse.get("a"));
            Assert.assertEquals(50.0, evaluateFalse.get("b"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
