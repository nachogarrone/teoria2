import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by nachogarrone on 31/8/16.
 */
public class TestWhileDo {
    @Test
    public void testWhileParse() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{i=1;while(i<=5)do{i=i+1;}}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertEquals(new Double(6.0),evaluate.get("i"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }
}
