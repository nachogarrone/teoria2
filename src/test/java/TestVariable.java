import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestVariable {
    @Test
    public void testVarParse(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{x=1;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            Assert.assertNull(evaluate.get("i"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
