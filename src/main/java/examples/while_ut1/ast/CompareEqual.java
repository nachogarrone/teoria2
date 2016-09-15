package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.*;

/**
 * Representación de las comparaciones por igual.
 */
public class CompareEqual extends Exp {
    public final Exp left;
    public final Exp right;

    public CompareEqual(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String unparse() {
        return "(" + left.unparse() + " == " + right.unparse() + ")";
    }

    @Override
    public String toString() {
        return "CompareEqual(" + left + ", " + right + ")";
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
        CompareEqual other = (CompareEqual) obj;
        return (this.left == null ? other.left == null : this.left.equals(other.left))
                && (this.right == null ? other.right == null : this.right.equals(other.right));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state) {
        return left.evaluate(state).equals(right.evaluate(state));
    }


    @SuppressWarnings("Duplicates")
    @Override
    public Object check(CheckState state) {
        Object leftO = this.left.check(state);
        Object rightO = this.right.check(state);

        if (leftO == null || rightO == null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }

        Types leftType = ((ObjectState)leftO).getVariable();
        Types rightType = ((ObjectState)rightO).getVariable();
        switch (leftType) {
            case NUMERIC:
                if (rightType == Types.NUMERIC) return new ObjectState(Types.NUMERIC, true);
                Logger.log(this.getClass().getName(), "No se puede comparar con distintos tipos de variables");
                return new ObjectState(Types.BOOLEAN, true);
            case STRING:
                if (rightType == Types.STRING) return new ObjectState(Types.STRING, true);
                Logger.log(this.getClass().getName(), "No se puede comparar con distintos tipos de variables");
                return new ObjectState(Types.BOOLEAN, true);
            case BOOLEAN:
                if (rightType == Types.BOOLEAN) return new ObjectState(Types.BOOLEAN, true);
                Logger.log(this.getClass().getName(), "No se puede comparar con distintos tipos de variables");
                return new ObjectState(Types.BOOLEAN, true);
            default:
                Logger.log(this.getClass().getName(), "No se puede comparar con distintos tipos de variables");
                return new ObjectState(Types.BOOLEAN, true);
        }
    }
//	public static CompareEqual generate(Random random, int min, int max) {
//		AExp left; AExp right;
//		left = AExp.generate(random, min-1, max-1);
//		right = AExp.generate(random, min-1, max-1);
//		return new CompareEqual(left, right);
//	}
}
