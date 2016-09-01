import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestIf {
    @Test
    public void testIfParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{if(true) then{a = 100;}}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("a"));
            Assert.assertEquals(100.0, evaluate.get("a"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
