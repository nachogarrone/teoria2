package examples.while_ut1.ast;

import examples.while_ut1.Logger;
import examples.while_ut1.analyzer.CheckState;
import examples.while_ut1.analyzer.ObjectState;
import examples.while_ut1.analyzer.Types;

import java.util.HashMap;

/**
 * Created by nachogarrone on 14/9/16.
 */
public class Declaration extends Stmt {
    private Types type;
    private String id;
    private Exp expression;

    public Declaration(Types type, String id, Exp expression) {
        this.type = type;
        this.id = id;
        this.expression = expression;
    }

    public String unparse() {
        return type + " " + id + " = " + expression.unparse() + "; ";
    }

    public String toString() {
        return "Declaration(" + id + ", " + type + ", " + expression + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Declaration that = (Declaration) o;

        if (!type.equals(that.type)) return false;
        if (!id.equals(that.id)) return false;
        return expression != null ? expression.equals(that.expression) : that.expression == null;

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + id.hashCode();
        result = 31 * result + (expression != null ? expression.hashCode() : 0);
        return result;
    }

    public HashMap<String, Object> evaluate(HashMap<String, Object> state) {
        Object value = expression.evaluate(state);
        state.put(id, value);
        return state;
    }

    public CheckState check(CheckState state) {
        ObjectState newState = null;
        if (expression != null) newState = (ObjectState) expression.check(state);

        if (state.getStateHashMap().containsKey(id)) {
            if (!state.getStateHashMap().get(id).getVariable().equals(newState.getVariable())) {
                Logger.log(getClass().getName(), "Variable ya definida. No se puede cambiar el tipo!");
            }
        } else {
            if (newState == null) {
                state.getStateHashMap().put(id, new ObjectState(type, false));
            } else {
                if (newState.getVariable().equals(type)) {
                    state.getStateHashMap().put(id, newState);
                } else {
                    if (newState.getVariable().equals(Types.INTEGER) && state.getStateHashMap().get(id).getVariable().equals(Types.NUMERIC)) {
                        Logger.log(getClass().getName(), "Casteando de : " + newState.getVariable() + " a : " + type);
                        state.getStateHashMap().get(id).setVariable(Types.NUMERIC);
                    }
                }
            }
        }
        return state;
    }
}
