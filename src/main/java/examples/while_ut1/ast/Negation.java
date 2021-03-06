package examples.while_ut1.ast;

public class Negation extends Exp {
    public final Exp condition;

    public Negation(Exp condition) {
        this.condition = condition;
    }

    @Override
    public String unparse() {
        return "~" + condition.unparse();
    }

    @Override
    public String toString() {
        return unparse();
//        return "Negation(" + condition + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Negation other = (Negation) obj;
        return (this.condition == null ? other.condition == null : this.condition.equals(other.condition));
    }
}
