package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.*;

/**
 * Representación de las negaciones de expresiones booleanas.
 */
public class Negation extends Exp {
    public final Exp condition;

    public Negation(Exp condition) {
        this.condition = condition;
    }

    @Override
    public String unparse() {
        return "(!" + condition.unparse() + ")";
    }

    @Override
    public String toString() {
        return "Negation(" + condition + ")";
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

    @Override
    public Object evaluate(HashMap<String, Object> state) {
        return !(Boolean) condition.evaluate(state);
    }

    @Override
    public Object check(CheckState state) {
        Object leftO = this.condition.check(state);

        if (leftO == null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }

        Types type = ((ObjectState) leftO).getVariable();
        switch (type) {
            case NUMERIC:
                Logger.log(this.getClass().getName(), "No se puede hacer un NOT con un número");
                return new ObjectState(Types.BOOLEAN, true);
            case STRING:
                Logger.log(this.getClass().getName(), "No se puede hacer un NOT con un string");
                return new ObjectState(Types.BOOLEAN, true);
            case BOOLEAN:
                return new ObjectState(Types.BOOLEAN, true);
            default:
                Logger.log(this.getClass().getName(), "No se puede hacer un NOT con variable desconocida");
                return new ObjectState(Types.BOOLEAN, true);
        }
    }

//	public static Negation generate(Random random, int min, int max) {
//		BExp condition;
//		condition = BExp.generate(random, min-1, max-1);
//		return new Negation(condition);
//	}
}
