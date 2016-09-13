package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;

import java.util.*;

/**
 * Representación de sumas.
 */
public class Addition extends Exp {
    public final Exp left;
    public final Exp right;

    public Addition(Exp left, Exp right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String unparse() {
        return "(" + left.unparse() + " + " + right.unparse() + ")";
    }

    @Override
    public String toString() {
        return "Addition(" + left + ", " + right + ")";
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
        Addition other = (Addition) obj;
        return (this.left == null ? other.left == null : this.left.equals(other.left))
                && (this.right == null ? other.right == null : this.right.equals(other.right));
    }

    @Override
    public Object evaluate(HashMap<String, Object> state) {
        if ((left.evaluate(state) instanceof Double) && (right.evaluate(state) instanceof Double)) {
            return (Double) left.evaluate(state) + (Double) right.evaluate(state);
        } else {
            return left.evaluate(state).toString() + right.evaluate(state).toString();
        }
    }

    @Override
    public Object check(CheckState state) {
        Object leftO = this.left.check(state);
        Object rightO = this.right.check(state);

        if (leftO != null && rightO != null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }

        switch ((ObjectState.Types) leftO) {
            case NUMERIC:
                if (rightO == ObjectState.Types.NUMERIC) return ObjectState.Types.NUMERIC;
                Logger.log(this.getClass().getName(), "No se puede sumar numeros con otros tipos de variables");
                return ObjectState.Types.NUMERIC;
            case STRING:
                if (rightO == ObjectState.Types.STRING) return ObjectState.Types.STRING;
                Logger.log(this.getClass().getName(), "No se puede sumar string con otros tipos de variables");
                return ObjectState.Types.NUMERIC;
            case BOOLEAN:
                Logger.log(this.getClass().getName(), "No se puede sumar boolenaos");
                return ObjectState.Types.NUMERIC;
            default:
                Logger.log(this.getClass().getName(), "Tipo desconocido en suma");
                return ObjectState.Types.NUMERIC;
        }

    }

//	public static Addition generate(Random random, int min, int max) {
//		Exp left; Exp right;
//		left = Exp.generate(random, min-1, max-1);
//		right = Exp.generate(random, min-1, max-1);
//		return new Addition(left, right);
//	}
}
