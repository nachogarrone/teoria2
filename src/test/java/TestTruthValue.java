import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestTruthValue {
    @Test
    public void testBoolParse(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{x=true;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertTrue((Boolean) evaluate.get("x"));
            Assert.assertFalse((Boolean) evaluate.get("x")==false);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
