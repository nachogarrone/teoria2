import examples.while_ut1.ast.Exp;
import examples.while_ut1.parser.Parser;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by nachogarrone on 29/8/16.
 */
public class Tests extends TestCase {

    public void test1() throws Exception {
        Exp exp = (Exp) Parser.parse("T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("F").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("T->T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("(T->T)").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("T<->T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("T\\/T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("T/\\T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));

        exp = (Exp) Parser.parse("~T").value;
        assertEquals(exp, ((Exp) Parser.parse(exp.unparse()).value));
    }
}
