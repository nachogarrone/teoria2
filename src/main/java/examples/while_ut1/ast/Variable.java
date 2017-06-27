package examples.while_ut1.ast;

/**
 * Created by nachogarrone on 6/20/17.
 */
public class Variable extends Exp {
    public final String id;

    public Variable(String id) {
        this.id = id;
    }

    @Override
    public String unparse() {
        return id;
    }

    @Override
    public String toString() {
        return unparse();
//        return "Variable(" + id + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Variable other = (Variable) obj;
        return (this.id == null ? other.id == null : this.id.equals(other.id));
    }
}
