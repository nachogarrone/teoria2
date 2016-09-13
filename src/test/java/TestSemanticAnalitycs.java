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
            checkS.getStateHashMap().containsKey("x");
            Assert.assertNotNull(checkS.getStateHashMap().values());
            //Assert.assertEquals(100.0, evaluate.get("x"));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test2(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = 1 + false;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test3(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = x + 1;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test4(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = y * 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    //@Test
//    public void test5(){
//        try{
//            Stmt statement =(Stmt) (Parser.parse("{while 1 do {};}").value);
//            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
//            Assert.assertNotNull(evaluate.get(""));
//            //Assert.assertEquals(100.0, evaluate.get("x"));
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
    // @Test
//    public void test6(){
//        try{
//            Stmt statement =(Stmt) (Parser.parse("{if 2 then {} else {};}").value);
//            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
//            Assert.assertNotNull(evaluate.get(""));
//            //Assert.assertEquals(100.0, evaluate.get("x"));
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            Assert.fail();
//        }
//    }
    @Test
    public void test7(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{if \"x\" then {} else {};}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get(""));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test7(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = \"x\" + 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get(""));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test8(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = 17; x = true; x = x + 1;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get(""));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test9(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = true <= \"false\";}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get(""));
            //Assert.assertEquals(100.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }
    @Test
    public void test10(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{x = true; while x do x = 1; x = x + 1;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            Assert.assertEquals(2.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

    @Test
    public void test11(){
        try{
            Stmt statement =(Stmt) (Parser.parse("{if true then x = 1; else x = \"1\"; x = x * 2;}").value);
            HashMap<String, Object> evaluate = statement.evaluate(new HashMap<String, Object>());
            Assert.assertNotNull(evaluate.get("x"));
            Assert.assertEquals(2.0, evaluate.get("x"));

        }
        catch (Exception e){
            e.printStackTrace();
            Assert.fail();
        }
    }

}
