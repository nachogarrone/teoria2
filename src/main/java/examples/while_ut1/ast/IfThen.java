package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.HashMap;

/**
 * Representación de las sentencias condicionales.
 */
public class IfThen extends Stmt {
    public final Exp condition;
    public final Stmt thenBody;

    public IfThen(Exp condition, Stmt thenBody) {
        this.condition = condition;
        this.thenBody = thenBody;
    }

    @Override
    public CheckState check(CheckState state) {
        Object condition = this.condition.check(state);
        CheckState body = this.thenBody.check(state);

        if (condition == null || thenBody == null) {
            Logger.log(this.getClass().getName(), "El compilador no se puede recuperar!");
        }

        ObjectState conditionType = (ObjectState) condition;
        if (!conditionType.getVariable().equals(Types.BOOLEAN)) {
            Logger.log(this.getClass().getName(), "Condición de IF no Booleana. Tipo: "+conditionType.getVariable());
        }

        return body;
    }


//    public static IfThen generate(Random random, int min, int max) {
//        BExp condition;
//        Stmt thenBody;
//        condition = BExp.generate(random, min - 1, max - 1);
//        thenBody = Stmt.generate(random, min - 1, max - 1);
//        return new IfThen(condition, thenBody);
//    }

    @Override
    public String unparse() {
        return "if " + condition.unparse() + " then { " + thenBody.unparse() + " } ";
    }

    @Override
    public String toString() {
        return "IfThen(" + condition + ", " + thenBody + ")";
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
        result = result * 31 + (this.thenBody == null ? 0 : this.thenBody.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        IfThen other = (IfThen) obj;
        return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
                && (this.thenBody == null ? other.thenBody == null : this.thenBody.equals(other.thenBody));
    }

    public HashMap<String, Object> evaluate(HashMap<String, Object> state) throws RuntimeException {
        if ((Boolean) condition.evaluate(state)) {
            return thenBody.evaluate(state);
        }
        return state;
    }
}
