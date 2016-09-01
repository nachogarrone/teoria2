import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestLength {
    @Test
    public void testLengthParse(){
        try {
            Stmt statement = (Stmt) (Parser.parse("{a = \"hola\"; largo = length(a);}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("largo"));
            Assert.assertEquals(4, evaluate.get("largo"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
