package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;

import java.util.*;

/**
 * Representación de las sentencias condicionales.
 */
public class IfThenElse extends Stmt {
    public final Exp condition;
    public final Stmt thenBody;
    public final Stmt elseBody;

    public IfThenElse(Exp condition, Stmt thenBody, Stmt elseBody) {
        this.condition = condition;
        this.thenBody = thenBody;
        this.elseBody = elseBody;
    }

    @Override
    public String unparse() {
        return "if " + condition.unparse() + " then { " + thenBody.unparse() + " } else { " + elseBody.unparse() + " }";
    }

    @Override
    public String toString() {
        return "IfThenElse(" + condition + ", " + thenBody + ", " + elseBody + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
        result = result * 31 + (this.thenBody == null ? 0 : this.thenBody.hashCode());
        result = result * 31 + (this.elseBody == null ? 0 : this.elseBody.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IfThenElse other = (IfThenElse) obj;
        return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
                && (this.thenBody == null ? other.thenBody == null : this.thenBody.equals(other.thenBody))
                && (this.elseBody == null ? other.elseBody == null : this.elseBody.equals(other.elseBody));
    }

    public HashMap<String, Object> evaluate(HashMap<String, Object> state)
            throws RuntimeException {
        if ((Boolean) condition.evaluate(state)) {
            return thenBody.evaluate(state);
        } else {
            if (elseBody != null) {
                return elseBody.evaluate(state);
            }
        }
        return state;

    }

    public CheckState check(CheckState state) {
        Object condition = this.condition.check(state);
        CheckState thenBody = this.thenBody.check(state);
        CheckState elseBody = this.elseBody.check(state);

        if (condition == null || thenBody == null || elseBody == null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }

        ObjectState conditionType = (ObjectState) condition;
        if (!conditionType.getVariable().equals(ObjectState.Types.BOOLEAN)) {
            Logger.log(this.getClass().getName(), "Condición de IF no Booleana. Tipo: " + conditionType.getVariable());
        }

        CheckState result = thenBody;
        result.getStateHashMap().entrySet().retainAll(elseBody.getStateHashMap().entrySet());
        return result;
    }


//	public static IfThenElse generate(Random random, int min, int max) {
//		BExp condition; Stmt thenBody; Stmt elseBody;
//		condition = BExp.generate(random, min-1, max-1);
//		thenBody = Stmt.generate(random, min-1, max-1);
//		elseBody = Stmt.generate(random, min-1, max-1);
//		return new IfThenElse(condition, thenBody, elseBody);
//	}
}
