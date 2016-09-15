import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.ast.Stmt;
import examples.while_ut1.parser.Parser;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Emanuel Chalela on 12/9/2016.
 */
public class TestSemanticAnalitycs {
    @Test
    public void test1() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{x = true * 2;}").value);
            CheckState checkS = statement.check(new CheckState());
            Assert.assertNotNull(checkS.getStateHashMap().values());
            Assert.assertFalse(checkS.getStateHashMap().containsKey("x"));
            Assert.assertNotEquals(ObjectState.Types.BOOLEAN, checkS.getStateHashMap().containsKey("x"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test2() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{x = 1 + false;}").value);
            CheckState checkS = statement.check(new CheckState());
            Assert.assertNotNull(checkS.getStateHashMap().values());
            Assert.assertFalse(checkS.getStateHashMap().containsKey("x"));
            Assert.assertNotEquals(ObjectState.Types.NUMERIC, checkS.getStateHashMap().containsKey("x"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test3() {
        try {
            Stmt statement = (Stmt) (Parser.parse("{x = x + 1;}").value);
            CheckState checkS = statement.check(new CheckState());
            Assert.assertNotNull(checkS.getStateHashMap().values());
            Assert.assertFalse(checkS.getStateHashMap().containsKey("x"));
            Assert.assertNotEquals(ObjectState.Types.NUMERIC, checkS.getStateHashMap().containsKey("x"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test4() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{x = y * 2;}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertFalse(state.getStateHashMap().containsKey("y"));
        Assert.assertTrue(state.getStateHashMap().containsKey("x"));
        Assert.assertNotEquals(ObjectState.Types.NUMERIC, state.getStateHashMap().containsKey("x"));
    }

    @Test
    public void test5() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{while 1 do {}}").value);
        CheckState checkS = statement.check(new CheckState());
        Assert.assertNotNull(checkS.getStateHashMap().values());
        Assert.assertFalse(checkS.getStateHashMap().containsKey(1));
    }

    @Test
    public void test6() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{if 2 then {} else {}}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertNotNull(state.getStateHashMap().values());
        Assert.assertFalse(state.getStateHashMap().containsKey(2));
    }

    @Test
    public void test7() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{if \"x\" then {} else {}}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertFalse(state.getStateHashMap().containsKey("x"));
    }

    @Test
    public void test8() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{x = \"x\" + 2;}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertNotNull(state.getStateHashMap().get("x"));
        Assert.assertEquals(ObjectState.Types.NUMERIC, state.getStateHashMap().get("x").getVariable());
    }

    @Test
    public void test9() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{x = 17; x = true; x = x + 1;}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertTrue(state.getStateHashMap().containsKey("x"));
        Assert.assertEquals(ObjectState.Types.NUMERIC, state.getStateHashMap().get("x").getVariable());
    }

    @Test
    public void test10() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{x = true <= \"false\";}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertNotNull(state.getStateHashMap().containsKey("x"));
        Assert.assertEquals(ObjectState.Types.BOOLEAN, state.getStateHashMap().get("x").getVariable());
    }

    @Test
    public void test11() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{x = true; while x do x = 1; x = x + 1;}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertTrue(state.getStateHashMap().containsKey("x"));
        Assert.assertEquals(ObjectState.Types.BOOLEAN, state.getStateHashMap().get("x").getVariable());
    }

    @Test
    public void test12() throws Exception {
        Stmt statement = (Stmt) (Parser.parse("{if true then x = 1; else x = \"1\"; x = x * 2;}").value);
        CheckState state = statement.check(new CheckState());
        Assert.assertTrue(state.getStateHashMap().containsKey("x"));
        Assert.assertEquals(ObjectState.Types.NUMERIC, state.getStateHashMap().get("x").getVariable());
    }

}
