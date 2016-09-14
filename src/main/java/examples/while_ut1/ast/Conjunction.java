package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;

import java.util.*;

/**
 * Representación de conjunciones booleanas (AND).
 */
public class Conjunction extends Exp {
    public final Exp left;
    public final Exp right;

    public Conjunction(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String unparse() {
        return "(" + left.unparse() + " and " + right.unparse() + ")";
    }

    @Override
    public String toString() {
        return "Conjunction(" + left + ", " + right + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.left == null ? 0 : this.left.hashCode());
        result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Conjunction other = (Conjunction) obj;
        return (this.left == null ? other.left == null : this.left.equals(other.left))
                && (this.right == null ? other.right == null : this.right.equals(other.right));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state) {
        return (Boolean) left.evaluate(state) && (Boolean) right.evaluate(state);
    }

    @Override
    public Object check(CheckState state) {
        Object leftO = this.left.check(state);
        Object rightO = this.right.check(state);

        if (leftO == null || rightO == null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }
        switch ((ObjectState.Types) leftO) {
            case NUMERIC:
                Logger.log(this.getClass().getName(), "No se puede hacer un AND con un número");
                return new ObjectState(ObjectState.Types.BOOLEAN, true);
            case STRING:
                Logger.log(this.getClass().getName(), "No se puede hacer un AND con un string");
                return new ObjectState(ObjectState.Types.BOOLEAN, true);
            case BOOLEAN:
                if (rightO == ObjectState.Types.BOOLEAN) return new ObjectState(ObjectState.Types.BOOLEAN, true);
                Logger.log(this.getClass().getName(), "No se puede hacer un AND con otra cosa que no sea booleano.");
                return new ObjectState(ObjectState.Types.BOOLEAN, true);
            default:
                Logger.log(this.getClass().getName(), "No se puede hacer un AND con distintos tipos");
                return new ObjectState(ObjectState.Types.BOOLEAN, true);
        }
    }


//	public static Conjunction generate(Random random, int min, int max) {
//		BExp left; BExp right;
//		left = BExp.generate(random, min-1, max-1);
//		right = BExp.generate(random, min-1, max-1);
//		return new Conjunction(left, right);
//	}
}
