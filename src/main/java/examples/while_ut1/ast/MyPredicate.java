package examples.while_ut1.ast;

import java.util.List;

/**
 * Created by nachogarrone on 6/26/17.
 */
public class MyPredicate extends Exp {
    public final String id;
    public final List<Exp> expressions;

    public MyPredicate(String id, List<Exp> expressions) {
        this.id = id;
        this.expressions = expressions;
    }

    @Override
    public String unparse() {
        StringBuilder res = new StringBuilder();
        res.append(id + "(");
        expressions.forEach(exp -> res.append(exp.unparse()));
        res.append(")");
        return res.toString();
    }

    @Override
    public String toString() {
        return unparse();
        //return "CompareEqual(" + left + ", " + right + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPredicate myPredicate = (MyPredicate) o;

        if (id != null ? !id.equals(myPredicate.id) : myPredicate.id != null) return false;
        return expressions != null ? expressions.equals(myPredicate.expressions) : myPredicate.expressions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (expressions != null ? expressions.hashCode() : 0);
        return result;
    }
}
