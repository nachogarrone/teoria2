import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestDefined {
    @Test
    public void testDefinedParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = defined(x); x=1; b = defined(x);}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertFalse((Boolean) evaluate.get("a"));
            Assert.assertTrue((Boolean) evaluate.get("b"));
            Assert.assertEquals(1.0, evaluate.get("x"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
